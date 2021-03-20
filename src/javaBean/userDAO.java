package javaBean;

//���ݿ������

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javaBean.user;
import javaBean.DBManager;

public class userDAO {
	//user���ݿ�����µĹ���Ա
	public static boolean insert(user user) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBManager.getConnection();
			String sql = "INSERT INTO t_userinfo (userName, password) VALUES (?, ?);";
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());//����һ���ʺŸ�ֵuser.getUsername()
			statement.setString(2, user.getPassword());
			int count = statement.executeUpdate();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(connection, statement);
		}
		return false;
	}
	
	//�����ݿ�����޸Ĺ���Ա��Ϣ
	public boolean update(user user) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBManager.getConnection();
			String sql = "UPDATE t_userinfo SET userName = ?, password= ? WHERE userName = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getUsername());
			int count = statement.executeUpdate();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(connection, statement);
		}
		return false;
	}
	
	//ɾ�����ݿ����Ա��Ϣ
	public static boolean delete(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DBManager.getConnection();
			String sql = "DELETE FROM t_userinfo WHERE userName = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			int count = statement.executeUpdate();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(connection, statement);
		}
		return false;
	}
	
	//�������ݿ��й���Ա
	public user findByName(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBManager.getConnection();
			String sql = "SELECT * FROM t_userinfo WHERE userName = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				return new user(resultSet.getString("userName"), 
						resultSet.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(connection, statement, resultSet);
		}
		return null;
	}
	
	//�������ݿ����й���Ա��Ϣ
	public List<user> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<user> list = new ArrayList<>();
		try {
			connection = DBManager.getConnection();
			String sql = "SELECT * FROM t_userinfo";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				user user = new user( resultSet.getString("userName"), resultSet.getString("password"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.closeAll(connection, statement, resultSet);
		}
		return list;
	}
}

