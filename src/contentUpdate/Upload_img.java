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
 
		PreparedStatement pstmt;//获得PreparedStatment对象 ，PreparedStatment执行SQL查询语句的API,比 Statement 更快
		
		//加载数据库驱动
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("驱动找不到");
		}
		List Files = new ArrayList();//存取上传文件 
		String name = "";//存取上传人姓名 DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建一个解析器工厂
        DiskFileItemFactory  fu =new DiskFileItemFactory ();//得到解析器，处理上传的文件数据，并将表单中每个输入项封装成一个FileItem 对象中
        ServletFileUpload upload = new ServletFileUpload(fu);
		upload.setHeaderEncoding("utf-8");
		try {
			//存取表单所有信息
			List<FileItem> list = upload.parseRequest(request);//取得表单的数据内容
			//此层增强for循环遍历表单中有多少个上传文件将文件存到list中
			for(FileItem items:list){
				if(items.isFormField()){//判断是否不是文件
					if(items.getFieldName().equals("name")){
						name=new String(items.getString().getBytes("UTF-8"),"UTF-8");
						System.out.println(name);
					}
					System.out.println(items.getFieldName());
					System.out.println("到这步了");
				}else{
					Files.add(items);
				}
			}
			//sql插入语句
			String sql ="insert into img (name,img) values(?,?)";
			for(int i=0;i<Files.size();i++){
				FileItem item = (FileItem)Files.get(i);//从集合取出文件
				String filename = item.getName();//获得文件名
				InputStream file = item.getInputStream();//将文件转为输入流
				// read(byte[])方法,返回读入缓冲区的总字节数  
				byte[] buffer = new byte[file.available()];//将字节数组直接存进去数据库就可以
				file.read(buffer);
				System.out.println("到第二部了");
				try {
					con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/centeroverview?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false", "root", "123456");
					System.out.println("2");
					pstmt = con.prepareStatement(sql);//预处理
					System.out.println("3");
					pstmt.setString(1, name);//将第一个占位符（?）设值
					System.out.println("4");
					pstmt.setBytes(2, buffer);//将第二个占位符设值
					System.out.println("5");
					pstmt.executeUpdate();//执行语句
					System.out.println("6");
					file.close();//将流关闭
					System.out.println("7");
					System.out.println("插入图片成功");
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
