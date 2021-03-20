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
 
		response.setContentType("image/*");//设置为图片方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Connection con;
		PreparedStatement pstmt;//获得PreparedStatement对象
		ResultSet rs=null;
		String name=request.getParameter("name");
		//通过img 的src 获得上传人
		//String name =new String(request.getParameter("name"));
		//String name =new String(request.getParameter("name").getBytes("utf-8"),"utf-8");
		System.out.println(name);
		System.out.println("第一步");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("第2步");
		} catch (ClassNotFoundException e2) {
			System.out.println("驱动找不到");
		}
		String sql="select * from img where name =?";
		System.out.println("第3步");
		List img = new ArrayList();//存放img名字用于页面显示；
		System.out.println("第4步");
		try{
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/centeroverview?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false", "root", "123456");
			System.out.println("第5步");
			try{
				//实例化PreparedStatement对象
				pstmt =  con.prepareStatement(sql);
				System.out.println("第6步");
				pstmt.setString(1, name);//查询条件根据上传人查询
				System.out.println("第7步");
				rs=pstmt.executeQuery();//执行查询
				System.out.println("第8步");
				if(rs.next()){//循环取出所有图片
					System.out.println("s?");
					byte[] buff =rs.getBytes("img");//图片所在的字段名，前面存的是byte 现在相对应的取
					System.out.println("第9步");
					OutputStream os = response.getOutputStream();//获得输出流
					System.out.println("第10步");
					os.write(buff);//将其输出页面
					System.out.println("11步");
					System.out.println("取出成功");
				}
				pstmt.close();
				rs.close();
			}catch(Exception e){
				System.out.println("取出失败 "+e);
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

