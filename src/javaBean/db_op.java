package javaBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db_op{
		public boolean select_1(user u) {//��ѯ�û��Ƿ��Ѿ�ע��
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver"); 
				 System.out.println("��������");
			  Connection conn = DriverManager.getConnection(
			          "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false","root","123456");
			  System.out.println("connection������");
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
		public boolean select_2(String u) {//��ע��ʱ��ѯ�Ƿ��Ѿ����������Ѿ�ע��
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
		public void append(user u) {//ע��ʱ����û���Ϣ
			String xm=u.getUsername();
			String pass=u.getPassword();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("�������سɹ�");
				Connection conn = DriverManager.getConnection(
				          "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false","root","123456");
				System.out.println("���ӳɹ�");
				PreparedStatement p=conn.prepareStatement("insert into T_userInfo(userName,password) values(?,?)");
				p.setString(1,xm);
				p.setString(2, pass);
				p.executeUpdate();
				Statement sta = conn.createStatement();
				  ResultSet rs = sta.executeQuery("SELECT * FROM t_userinfo");
				  System.out.println("��ѯ���������£�");
				  while (rs.next()) {        //ѭ����������α������ƶ�������ĩβ����false
				    //�����ֶ����ƻ�ø����ֶε�ֵ
				    System.out.print(rs.getString("userName") + "\t");     //����ַ���
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




