package javaBean;

//Ô¤ÐÞ¸Äservlet PreUpdateServlet
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.user;
import javaBean.userDAO;

@WebServlet("/function/preUpdate")
public class PreUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		userDAO dao = new userDAO();
		user user = dao.findByName(name);
		request.setAttribute("user", user);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
