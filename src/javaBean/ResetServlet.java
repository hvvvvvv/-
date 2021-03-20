package javaBean;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaBean.user;
import javaBean.userDAO;

@WebServlet("/function/reset")
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		userDAO dao = new userDAO();
		user user = dao.findByName(name);
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); 
			 System.out.println("包连接上");
		  Connection conn = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false","root","123456");
		  System.out.println("connection连接上");
		  Statement ps=conn.createStatement();
		  String sql="UPDATE t_userinfo SET  password= 123456 WHERE userName ="+ name +"";
		  int count=ps.executeUpdate(sql);
		  System.out.println("更新成功");		  
	}catch(Exception e) {
		e.printStackTrace();
	}
		}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
