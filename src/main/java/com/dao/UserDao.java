package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.StudentBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class UserDao {

	public UserBean getUserByEmailId(String emailid ,String password) {
		
		UserBean userBean = null;
		
		String selectByEmailId  = " SELECT * FROM user WHERE emailid = ? and  password = ?";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		
		if (conn != null) {
			
			try {
				
				pstmt = conn.prepareStatement(selectByEmailId);
				
				pstmt.setString(1, emailid);
				pstmt.setString(2, password);
				
				
				rs = pstmt.executeQuery();
				
				System.out.println("rs :"+rs);
				
				while(rs.next()) {
					
					 int id =rs.getInt(1) ;
					 String  username = rs.getString(2);
					 String  emailid1 = rs.getString(3) ;
					 String  password1 = rs.getString(4) ;
					 
					 System.out.println(id+" "+username+" "+emailid1+" "+password1);
					
					 userBean  = new UserBean(id, username, emailid1, password1);
					 
					 System.out.println( userBean.getId()+" "+userBean.getUsername()+" "+userBean.getEmailid()+" "+userBean.getPassword());
					 
					 return userBean;
					 
				}
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("UserDao -------> getUserByEmailId()----->Database Not Connected"+conn);
		}
		
		return userBean;
		
	}
	
	public UserBean checkEmailId(String emailId) {
		
		UserBean userBean = null;
		
		String checkEmailId  = " SELECT * FROM user WHERE emailid = ?";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		
		if (conn != null) {
			
			try {
				
				pstmt = conn.prepareStatement(checkEmailId);
				
				pstmt.setString(1, emailId);
			
				rs = pstmt.executeQuery();
				
				System.out.println("rs :"+rs);
				
				while(rs.next()) {
					
					 int id =rs.getInt(1) ;
					 String  username = rs.getString(2);
					 String  emailid1 = rs.getString(3) ;
					 String  password1 = rs.getString(4) ;
					 
					 System.out.println(id+" "+username+" "+emailid1+" "+password1);
					
					 userBean  = new UserBean(id, username, emailid1, password1);
					 
					 System.out.println( userBean.getId()+" "+userBean.getUsername()+" "+userBean.getEmailid()+" "+userBean.getPassword());
					 
					 return userBean;
					 
				}
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("StudentDao -------> getAllStudentsRecords()----->Database Not Connected"+conn);
		}
		
		return userBean;
		
	}
	
	public int updatePssword(UserBean userBean,String password) {
		
		String updatePassword = "UPDATE user SET password=? WHERE emailid=?";
		
		System.out.println("updatePassword :"+updatePassword);
		
		Connection conn =  DBConnection.getConnection();
		
		PreparedStatement pstmt = null;

		int rowAffected = 0;
		
		if (conn != null) {
		try {

			String emailid = userBean.getEmailid();
			
			pstmt =  conn.prepareStatement(updatePassword);
			
			pstmt.setString(1, password);
			pstmt.setString(2, emailid);
			
			
			
			rowAffected = pstmt.executeUpdate();
			

			System.out.println("Update Password Query: => "+pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else {
			System.out.println("UserDao -------> updatePassword()----->Database Not Connected"+conn);
		}
		return rowAffected;
		
	}
	
	
	public static void main(String[] args) {
		
		/*
		UserDao userDao = new UserDao();
		
		UserBean userBean = new UserBean();
		
		userBean  = userDao.getUserByEmailId("user1@gmail.com", "admin1234@");
		
		System.out.println("userBean :"+userBean);
		
		System.out.println(userBean.getId()+" "+userBean.getUsername()+" "+userBean.getEmailid()+" "+userBean.getPassword());
		
		*/
	}
	
}
