package javaBean;
//Ôö¼Ó×¢²ásevlet InsertServlet

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.user;
import javaBean.userDAO;

@WebServlet("/function/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		//String password = request.getParameter("password");
		userDAO dao = new userDAO();
		user user = new user(name, "123456");
		dao.insert(user);
		response.sendRedirect("list");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

