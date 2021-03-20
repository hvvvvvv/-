package javaBean;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
@WebServlet("/function/login")
public   class LoginServlet extends HttpServlet{ 
public void doPost(HttpServletRequest request,HttpServletResponse response)  
		throws ServletException,IOException{ 
	user u=new user();
	String xm="";
	String ps="";
	xm=request.getParameter("username");
	ps=request.getParameter("password");
	u.setUsername(xm);
	u.setPassword(ps);
	HttpSession s=request.getSession(true);
	s.setAttribute("username", xm);
	s.setAttribute("password", ps);
	db_op d=new db_op();
	boolean tf=d.select_1(u);
	if(tf) {
		response.sendRedirect("/blessing/page_function/page_function.jsp");
	}
	else
	{
		response.sendRedirect("/blessing/function/login_err.jsp");
	}
}
}
