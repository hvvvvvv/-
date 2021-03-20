package javaBean;

import java.util.Properties;
import java.sql.*;
public class doa {
private String db_username;
private String db_password;
private String db_driver;
private String db_connection;
public String getDb_username() {
	return db_username;
}
public String getDb_password() {
	return db_password;
}
public void setDb_password(String db_password) {
	this.db_password=db_password;
}
public String getDb_driver() {
	return db_driver;
}
public void setDb_driver(String db_driver) {
	this.db_driver=db_driver;
}
public String getDb_connection() {
	return db_connection;
}
public void setDb_connection(String db_connection) {
	this.db_connection=db_connection;
}
}
