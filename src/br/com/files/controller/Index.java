package br.com.files.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.files.dao.DataSource;
import br.com.files.dao.FileDao;
import br.com.files.model.Arquivo;

@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Index() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource dt = new DataSource();
		FileDao dao = new FileDao(dt);
		List<Arquivo> arquivos = dao.listar();
		
		request.setAttribute("arquivos", arquivos);
		
		RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
		dis.forward(request, response);
	}
}
