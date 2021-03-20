package contentUpdate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

@WebServlet("/page/show_img")
public class show_img extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		response.setContentType("image/*");//����ΪͼƬ��ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Connection con;
		PreparedStatement pstmt;//���PreparedStatement����
		ResultSet rs=null;
		String name=request.getParameter("name");
		//ͨ��img ��src ����ϴ���
		//String name =new String(request.getParameter("name"));
		//String name =new String(request.getParameter("name").getBytes("utf-8"),"utf-8");
		System.out.println(name);
		System.out.println("��һ��");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("��2��");
		} catch (ClassNotFoundException e2) {
			System.out.println("�����Ҳ���");
		}
		String sql="select * from img where name =?";
		System.out.println("��3��");
		List img = new ArrayList();//���img��������ҳ����ʾ��
		System.out.println("��4��");
		try{
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/centeroverview?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false", "root", "123456");
			System.out.println("��5��");
			try{
				//ʵ����PreparedStatement����
				pstmt =  con.prepareStatement(sql);
				System.out.println("��6��");
				pstmt.setString(1, name);//��ѯ���������ϴ��˲�ѯ
				System.out.println("��7��");
				rs=pstmt.executeQuery();//ִ�в�ѯ
				System.out.println("��8��");
				if(rs.next()){//ѭ��ȡ������ͼƬ
					System.out.println("s?");
					byte[] buff =rs.getBytes("img");//ͼƬ���ڵ��ֶ�����ǰ������byte �������Ӧ��ȡ
					System.out.println("��9��");
					OutputStream os = response.getOutputStream();//��������
					System.out.println("��10��");
					os.write(buff);//�������ҳ��
					System.out.println("11��");
					System.out.println("ȡ���ɹ�");
				}
				pstmt.close();
				rs.close();
			}catch(Exception e){
				System.out.println("ȡ��ʧ�� "+e);
			}
		} catch (SQLException e1) {
			System.out.println(e1);
		}
	}  
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		doGet(request, response);
	}
}

