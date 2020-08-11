package br.com.files.controller;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.files.dao.DataSource;
import br.com.files.dao.FileDao;

@WebServlet("/downloadimage")
public class DownloadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadImage() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		DataSource dt = new DataSource();
		FileDao dao = new FileDao(dt);
		String pagina = "erro.jsp";
		
		try {
			byte[] img = dao.getImageById(id);
			response.setContentType("image/jpg");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + nome + "\"");
			
			OutputStream out = response.getOutputStream();
			out.write(img, 0, img.length);
			out.flush();
			out.close();
		
		}catch(Exception ex) {
			ex.printStackTrace();
			RequestDispatcher dis = request.getRequestDispatcher(pagina);
			dis.forward(request, response);
		}
		
	}

}
