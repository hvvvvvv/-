package javaBean;

//������DBManager
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 1.��������
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2. �������, ���������ֱ�Ϊ��url���û���������
		return DriverManager
				.getConnection( "jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false", 
				"root", "123456");
	}
	
	// �ȴ򿪣���ر�
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
	
	// �ȴ򿪣���ر�
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