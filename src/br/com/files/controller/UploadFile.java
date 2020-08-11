package br.com.files.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import br.com.files.dao.DataSource;
import br.com.files.dao.FileDao;

@WebServlet("/uploadfile")
@MultipartConfig
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadFile() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part file = request.getPart("arquivo");
		String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		int tamanho = (int) file.getSize();
		
		if(file != null) {
			InputStream input = file.getInputStream();
			DataSource dt = new DataSource();
			FileDao dao = new FileDao(dt);
			dao.inserir(input, fileName, tamanho);
			
			RequestDispatcher dis = request.getRequestDispatcher("upload-sucesso.jsp");
			dis.forward(request, response);
		}
	}
}
