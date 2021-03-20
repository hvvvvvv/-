package javaBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Super_op {
	public boolean select_1(user u) {//查询用户是否已经注册
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); 
			 System.out.println("包连接上");
		  Connection conn = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/user2?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false","root","123456");
		  System.out.println("connection连接上");
		ResultSet rs=null;
		Statement ps=null;
		String xm=u.getUsername();
		String pass=u.getPassword();
		String s1="select * from T_userInfo2 where userName='"+xm+"'and password='"+pass+"'";
			ps=conn.createStatement();
			rs=ps.executeQuery(s1);
			if(rs.next()) {
				rs.close();
				ps.close();
				conn.close();
				return true;
			}
			else {
				rs.close();
				ps.close();
				conn.close();
				return false;
			}
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}
}
