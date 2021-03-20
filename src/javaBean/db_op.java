package javaBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db_op{
		public boolean select_1(user u) {//查询用户是否已经注册
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver"); 
				 System.out.println("包连接上");
			  Connection conn = DriverManager.getConnection(
			          "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false","root","123456");
			  System.out.println("connection连接上");
			ResultSet rs=null;
			Statement ps=null;
			String xm=u.getUsername();
			String pass=u.getPassword();
			String s1="select * from T_userInfo where userName='"+xm+"'and password='"+pass+"'";
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
		public boolean select_2(String u) {//在注册时查询是否已经有重名的已经注册
			ResultSet rs=null;
			Statement ps=null;
		
			String s1="select * from T_userInfo where username="+u+"";
			try {Connection conn = DriverManager.getConnection(
			          "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false","root","123456");
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
				}
			catch(SQLException e) {
				return false;
			}
		}
		public void append(user u) {//注册时添加用户信息
			String xm=u.getUsername();
			String pass=u.getPassword();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("驱动加载成功");
				Connection conn = DriverManager.getConnection(
				          "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false","root","123456");
				System.out.println("连接成功");
				PreparedStatement p=conn.prepareStatement("insert into T_userInfo(userName,password) values(?,?)");
				p.setString(1,xm);
				p.setString(2, pass);
				p.executeUpdate();
				Statement sta = conn.createStatement();
				  ResultSet rs = sta.executeQuery("SELECT * FROM t_userinfo");
				  System.out.println("查询到数据如下：");
				  while (rs.next()) {        //循环将结果集游标往下移动，到达末尾返回false
				    //根据字段名称获得各个字段的值
				    System.out.print(rs.getString("userName") + "\t");     //获得字符串
				  }
				  rs.close();
				  sta.close();
				p.close();
				conn.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}




