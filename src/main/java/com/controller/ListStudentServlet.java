package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.bean.StudentBean;
import com.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		StudentDao  dao = new StudentDao();
		
		 ArrayList<StudentBean> list  = dao.getAllStudentsRecords();
		 
		 
//		 System.out.println("list.size  : "+list.size());
//		 
//		 out.println("<h3>Student List Page</h3>");
//		 
//		 out.println("<table border='1'> 		");
//		 out.println("			   				");
//		 out.println("	<tr>					");
//		 out.println("							");
//		 out.println(" 		<td>Roll No</td>	");
//		 out.println("		<td>Name</td>		");
//		 out.println("		<td>STD</td>		");
//		 out.println("		<td>Marks</td>		");
//		 out.println("		<td>Action</td>		");
//		 out.println("							");
//		 out.println("	</tr>					");
//		 
//		 
//		 for(int i = 0; i < list.size(); i++) {
//			 StudentBean s = list.get(i);
//			 
//			 out.println("	<tr>								");
//			 out.println("										");
//			 out.println(" 		<td> "+s.getRno()+"</td>		");
//			 out.println("		<td>"+s.getName()+"</td>		");
//			 out.println("		<td>"+s.getStd()+"</td>			");
//			 out.println("		<td>"+s.getMarks()+"</td>		");
//			 out.println("		<td> <a href='EditStudentServlet?rno="+s.getRno()+"'> EDIT | <a href='DeleteStudentServlet?rno="+s.getRno()+"'> DELETE</td>			");
//			 out.println("										");
//			 out.println("	</tr>								");
//			
//			 
//		 }
//		 
//		 
//		 out.println("</table>					");
//		 
//		 
		 request.setAttribute("list", list);
		 request.getRequestDispatcher("liststudent.jsp").forward(request, response);
		 
		 
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
