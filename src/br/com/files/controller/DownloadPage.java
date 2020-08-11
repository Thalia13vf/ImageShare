package br.com.files.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.files.dao.DataSource;
import br.com.files.dao.FileDao;
import br.com.files.model.Arquivo;

@WebServlet("/downloadpage")
public class DownloadPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadPage() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DataSource dt = new DataSource();
		FileDao dao = new FileDao(dt);
		
		Arquivo arq = dao.getImage(id);
		
		request.setAttribute("arquivo", arq);
		
		RequestDispatcher dis = request.getRequestDispatcher("download-image.jsp");
		dis.forward(request, response);
	
	}

}
