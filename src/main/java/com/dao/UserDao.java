package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.StudentBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class UserDao {

	public UserBean getUserByEmailId(String userName ,String password) {
		
		UserBean userBean = null;
		
		String selectByEmailId  = " SELECT username FROM user WHERE emailid = ? and  password = ?";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		
		if (conn != null) {
			
			try {
				
				pstmt = conn.prepareStatement(selectByEmailId);
				
				pstmt.setString(2, userName);
				
				pstmt.setString(4, password);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					
					 int id =rs.getInt(1) ;
					 String  username = rs.getString(2);
					 String  emailid = rs.getString(3) ;
					 String  password1 = rs.getString(4) ;
					
					 userBean  = new UserBean(id, username, emailid, password1);
					 
					 System.out.println( userBean.getId()+" "+userBean.getUsername()+" "+userBean.getEmailid()+" "+userBean.getPassword());
					 
				}
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("StudentDao -------> getAllStudentsRecords()----->Database Not Connected"+conn);
		}
		
		return userBean;
		
	}
	
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		
		UserBean userBean = new UserBean();
		
		userBean  = userDao.getUserByEmailId("user1", "admin1234@");
		
		System.out.println("userBean :"+userBean);
		
		System.out.println(userBean.getId()+" "+userBean.getUsername()+" "+userBean.getEmailid()+" "+userBean.getPassword());
	}
	
}
