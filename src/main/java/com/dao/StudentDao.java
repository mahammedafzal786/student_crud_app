package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.bean.StudentBean;
import com.util.DBConnection;

//PreparedStatement ---> "SQL Queries Execute"
//
//StudentDaoPrep---> student (student table)
public class StudentDao {

	/*
	 * Topic : CRUD Operation in Using PreparedStatement 
	 * 
	 * CRUD ---> Create , Read , Update , Delete 
	 * 
	 * */
	
	public int insertStudent(StudentBean sbean) {
		
		int rowAffected = 0;
		String insertQuery = "INSERT INTO student(name,std,marks) VALUES(?,?,?)";
		
		System.out.println("insertQuery : "+insertQuery);
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		if (conn != null) {
			
			try {
				
			pstmt = conn.prepareStatement(insertQuery);
			
			pstmt.setString(1, sbean.getName());
			pstmt.setString(2, sbean.getStd());
			pstmt.setInt(3, sbean.getMarks());
			
			rowAffected = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("StudentDao -------> insertStudent()----->Database Not Connected"+conn);
		}
		
		return rowAffected;
	}

	


	// student Table ----> update SQL
	public int updateStudent(StudentBean sbean,int rno1) {
		
		String updateQuery = "UPDATE student SET name=?,std=?,marks=? WHERE rno=?";
		
		System.out.println("updateQuery : "+updateQuery);
		
		Connection conn =  DBConnection.getConnection();
		
		PreparedStatement pstmt = null;

		int rowAffected = 0;
		
		if (conn != null) {
		try {

			pstmt =  conn.prepareStatement(updateQuery);
			
			pstmt.setString(1, sbean.getName());
			pstmt.setString(2, sbean.getStd());
			pstmt.setInt(3, sbean.getMarks());
			pstmt.setInt(4, rno1);
			
			
			rowAffected = pstmt.executeUpdate();
			

			System.out.println("Update Query: => "+pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else {
			System.out.println("StudentDao -------> updateStudent()----->Database Not Connected"+conn);
		}
		return rowAffected;
		
	}

	

	// student Table ----> delete  SQL
	public int deleteStudent(int rno) {
		
		int rowAffected = 0;
		String deleteQuery = "DELETE FROM student WHERE rno=?";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		if (conn != null) {
			
			try {
				
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1,rno);
				
				rowAffected = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
		} else {
			System.out.println("StudentDao -------> deleteStudent()----->Database Not Connected"+conn);
		}
		
		return rowAffected;
	}
	
	

	// student Table ----> select  SQL
	public ArrayList<StudentBean> getAllStudentsRecords() {
		
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		
		String selectQuery = "SELECT rno,name,std,marks  FROM student";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		StudentBean sbean = null;
		
		if (conn != null) {
			
			try {
				
				pstmt = conn.prepareStatement(selectQuery);
				
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					
					int rno = rs.getInt(1);
					String name = rs.getString(2);
					String std = rs.getString(3);
					int marks = rs.getInt(4);
					
					sbean = new StudentBean(rno, name, std, marks);
					list.add(sbean);
					
//					System.out.println("===>"+rno+" "+name+" "+std+" "+marks);
					 
				}
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("StudentDao -------> getAllStudentsRecords()----->Database Not Connected"+conn);
		}
		
		return list;
		
	}
	
	public Object getStudentByRno(int rno1) 
	{
		String selectStudentByRno = "SELECT * FROM student WHERE rno=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt  = null; 
		ResultSet rs = null;
		StudentBean sbean = null;
		
		if (conn!=null) 
		{
			try 
			{
				pstmt  = conn.prepareStatement(selectStudentByRno);
			
				pstmt.setInt(1, rno1);
				
				rs = pstmt.executeQuery();
				if (rs.next()) 
				{
					int rno = rs.getInt(1);
					String name = rs.getString(2);
					String std = rs.getString(3);
					int marks = rs.getInt(4);
					
					System.out.println(+rno+" "+name+" "+" "+std+" "+marks);
					
					sbean = new StudentBean(rno,name,std,marks);
					
					return sbean;
				} else 
				{
					System.out.println("Student record not found");
					return false;
				} 
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("Db not conncected");
		}
		return false; 
	}


	
	public static void main(String[] args) {
		

		//------------INSERT Student--------
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		System.out.println("Enter std: ");
		String std = sc.nextLine();
		System.out.println("Enter marks: ");
		int marks = sc.nextInt();
		
		StudentDaoPrep dao = new StudentDaoPrep();
		
		StudentBean sbean = new StudentBean(0, name, std, marks);
		
		int rowAffected = dao.insertStudent(sbean);
		
		if (rowAffected > 0) {
			
			System.out.println("Student record successfully inserted : "+rowAffected);
			
		} else {

			System.out.println("Student record Not inserted : "+rowAffected);
		}
		*/
		
		

		//-------------UPDATE Student Records----------------------
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rno which you want to Update : ");
		int rno = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		System.out.println("Enter std: ");
		String std = sc.nextLine();
		System.out.println("Enter marks: ");
		int marks = sc.nextInt();
		
		StudentDao dao = new StudentDao();
		
		StudentBean sbean = new StudentBean(0, name, std, marks);
		
		int rowAffected = dao.updateStudent(sbean,rno);
		
		if (rowAffected > 0) {
			
			System.out.println("Student record successfully Updated : "+rowAffected);
			
		} else {

			System.out.println("Student record Not Updated : "+rowAffected);
		}
		
		
		

		

		//-------------DELETE Student--------------
		/*		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rno which you want to Delete Student record : ");
		int rno = sc.nextInt();

		StudentDaoPrep dao = new StudentDaoPrep();
		
		int rowAffected =  dao.deleteStudent(rno);
	
		if (rowAffected > 0) {
			
			System.out.println("Student record successfully Deleted : "+rowAffected);
			
		} else {

			System.out.println("Student record Not Deleted : "+rowAffected);
		}
		*/
		


		//-----------------getAllStudentsRecords --------------------
		
		/*
		StudentDao dao = new StudentDao();         
		
		ArrayList<StudentBean> list = dao.getAllStudentsRecords();
		
		System.out.println("list.size(): "+list.size());
		
		for (int i = 0; i < list.size(); i++) {
			
			StudentBean s = list.get(i);
			
			System.out.println(s.getRno()+" "+s.getName()+" "+s.getStd()+" "+s.getMarks());
			
		}
		*/

	}
	
}
