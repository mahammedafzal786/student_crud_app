package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	// 1) make credentials 
	private static final String URLNAME     = "jdbc:mysql://localhost:3306/students";
	private static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME    = "root";
	private static final String PASSWORD    = "User1234@";
	
	//2) create getConnection method
	public static Connection getConnection() {
		
		Connection conn = null;
		try {

			//3) load Driver class
			Class.forName(DRIVERCLASS);
			
			//4) pass credentials into DriverManager's getConnection method
			conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
			
			//5) validate database connection object
			if(conn!=null) {
				System.out.println("DB Connected : "+conn);
			}else {
				System.out.println("DB not Connected : "+conn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void main(String[] args) {
		
		Connection conn =  DBConnection.getConnection();
		
		System.out.println("In main : "+conn);
		
	}
}
