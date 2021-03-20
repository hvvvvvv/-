package contentUpdate;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

@WebServlet("/function/upload_img")
public class Upload_img extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
 
		PreparedStatement pstmt;//���PreparedStatment���� ��PreparedStatmentִ��SQL��ѯ����API,�� Statement ����
		
		//�������ݿ�����
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("�����Ҳ���");
		}
		List Files = new ArrayList();//��ȡ�ϴ��ļ� 
		String name = "";//��ȡ�ϴ������� DiskFileItemFactory factory = new DiskFileItemFactory();
		//����һ������������
        DiskFileItemFactory  fu =new DiskFileItemFactory ();//�õ��������������ϴ����ļ����ݣ���������ÿ���������װ��һ��FileItem ������
        ServletFileUpload upload = new ServletFileUpload(fu);
		upload.setHeaderEncoding("utf-8");
		try {
			//��ȡ��������Ϣ
			List<FileItem> list = upload.parseRequest(request);//ȡ�ñ�����������
			//�˲���ǿforѭ�����������ж��ٸ��ϴ��ļ����ļ��浽list��
			for(FileItem items:list){
				if(items.isFormField()){//�ж��Ƿ����ļ�
					if(items.getFieldName().equals("name")){
						name=new String(items.getString().getBytes("UTF-8"),"UTF-8");
						System.out.println(name);
					}
					System.out.println(items.getFieldName());
					System.out.println("���ⲽ��");
				}else{
					Files.add(items);
				}
			}
			//sql�������
			String sql ="insert into img (name,img) values(?,?)";
			for(int i=0;i<Files.size();i++){
				FileItem item = (FileItem)Files.get(i);//�Ӽ���ȡ���ļ�
				String filename = item.getName();//����ļ���
				InputStream file = item.getInputStream();//���ļ�תΪ������
				// read(byte[])����,���ض��뻺���������ֽ���  
				byte[] buffer = new byte[file.available()];//���ֽ�����ֱ�Ӵ��ȥ���ݿ�Ϳ���
				file.read(buffer);
				System.out.println("���ڶ�����");
				try {
					con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/centeroverview?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false", "root", "123456");
					System.out.println("2");
					pstmt = con.prepareStatement(sql);//Ԥ����
					System.out.println("3");
					pstmt.setString(1, name);//����һ��ռλ����?����ֵ
					System.out.println("4");
					pstmt.setBytes(2, buffer);//���ڶ���ռλ����ֵ
					System.out.println("5");
					pstmt.executeUpdate();//ִ�����
					System.out.println("6");
					file.close();//�����ر�
					System.out.println("7");
					System.out.println("����ͼƬ�ɹ�");
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			}
		} catch (FileUploadException e2) {
			e2.printStackTrace();
		}
	}  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		doGet(request, response);
	}
}
