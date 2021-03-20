package javaBean;

//工具类DBManager
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 1.加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. 获得连接, 三个参数分别为：url，用户名，密码
		return DriverManager
				.getConnection( "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false", 
				"root", "123456");
	}
	
	// 先打开，后关闭
	public static void closeAll(Connection connection, PreparedStatement statement) {
		try {
			if(statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 先打开，后关闭
	public static void closeAll(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(connection, statement);
		}
	}
}