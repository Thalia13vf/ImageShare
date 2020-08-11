package br.com.files.controller;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.files.dao.DataSource;
import br.com.files.dao.FileDao;

@MultipartConfig
@WebServlet("/mostrarimagem")
public class MostrarImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MostrarImagem() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DataSource dt = new DataSource();
		FileDao dao = new FileDao(dt);

		byte[] img = dao.getImageById(id);

		response.setContentType("image/jpg");
		OutputStream out = response.getOutputStream();
		out.write(img);
		out.flush();
		out.close();
	}

}
