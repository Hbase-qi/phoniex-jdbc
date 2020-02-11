package com.qi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhoenixJDBC {

	public static final String URL="jdbc:phoenix:master,slave1,slave2:2181";
	public static final String DRIVER_CLASS="org.apache.phoenix.jdbc.PhoenixDriver";
	public static final String USERNAME="root";
	public static final String PASSWORD="123456";
	
	static{
		try {
			Class.forName(DRIVER_CLASS);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动类"+DRIVER_CLASS+"加载失败");
		}
	}
	
	public static Connection getConnection() {
		
		try {
			Connection connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
			return connection;
		} catch (SQLException e) {
			System.out.println("连接phoenix异常");
			e.printStackTrace();
			return null;
		}
	}
	
	public static void getStudent() throws SQLException {
		Connection connection=getConnection();
		Statement statement=connection.createStatement();
		String sql="select * from student";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			
			System.out.println("sno:"+resultSet.getInt("sno")+",sname:"+resultSet.getString("sname"));
		}
	}
	
	public static void main(String[] args) throws SQLException {
		getStudent();
	}
	
	
}



















