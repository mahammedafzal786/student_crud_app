package com.controller;

import java.io.IOException;

import com.bean.StudentBean;
import com.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertStudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String std = request.getParameter("std");
		int marks = Integer.parseInt( request.getParameter("marks"));
		
		StudentBean studentBean = new StudentBean(0,name,std,marks);
		
		StudentDao dao = new StudentDao();
		
		int rowAffected =  dao.insertStudent(studentBean);
		
		RequestDispatcher rd = null;
		
		if(rowAffected > 0) {
			rd = request.getRequestDispatcher("ListStudentServlet");
		}else {

			rd = request.getRequestDispatcher("registration.html");
		}
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
