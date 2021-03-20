package contentUpdate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



@WebServlet("/page/show_txt")
public class show_txt extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setContentType("text/plain");//����Ϊͼpain��ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Connection con;
		PreparedStatement pstmt;//���PreparedStatement����
		ResultSet rs=null;
		String content="";
		
		//ͨ��img ��src ����ϴ���
		//String name =new String(request.getParameter("name"));
		String name =new String(request.getParameter("name").getBytes("utf-8"),"utf-8");
		System.out.println("100");
		System.out.println(name);
		System.out.println("101");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("�����Ҳ���");
		}
		String sql="select * from txt where name=?";
		//String sql="SELECT CONVERT(1 USING utf8) FROM txt where name=?";
		/*String sql="select txt from txt where name =?";*/
		List txt = new ArrayList();//���img��������ҳ����ʾ��
		try{
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/centeroverview?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false", "root", "123456");
			try{
				System.out.println("102");
				//ʵ����PreparedStatement����
				pstmt =  con.prepareStatement(sql);
				System.out.println("103");
				pstmt.setString(1, name);//��ѯ���������ϴ��˲�ѯ
				System.out.println("104");
				rs=pstmt.executeQuery();//ִ�в�ѯ
				System.out.println("1111111");
				while(rs.next()){
					System.out.println("105");
					byte[] buff =rs.getBytes("txt");//ͼƬ���ڵ��ֶ�����ǰ������byte �������Ӧ��ȡ
					System.out.println("106");
					OutputStream os = response.getOutputStream();//��������
					System.out.println("107");
					os.write(buff);//�������ҳ��
					System.out.println("108");
					System.out.println("1ȡ�����ֳɹ�");
					
				/*	Blob blob = (Blob) rs.getBlob("txt");  
					int bolblen = (int) blob.length();  
					byte[] data = blob.getBytes(1, bolblen);  
					content = new String(data,"utf-8");
					response.setContentType("text/html");
					os = response.getOutputStream();//��������
					os.write(data);//�������ҳ��
					os.flush();
					System.out.println("2ȡ�����ֳɹ�");*/
				/*if(rs.next()){//ѭ��ȡ������ͼƬ
					byte[] buff =rs.getBytes("txt");//ͼƬ���ڵ��ֶ�����ǰ������byte �������Ӧ��ȡ
					OutputStream os = response.getOutputStream();//��������
					os.write(buff);//�������ҳ��
					System.out.println("ȡ�����ֳɹ�");*/
				}
				pstmt.close();
				rs.close();
                con.close();
			}catch(Exception e){
				System.out.println("ȡ��ʧ�� "+e);
			}
		} catch (SQLException e1) {
			System.out.println(e1);
		}
	}  
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		doGet(request, response);
	}
}
