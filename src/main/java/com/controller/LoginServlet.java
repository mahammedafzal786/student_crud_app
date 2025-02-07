package com.controller;

import java.io.IOException;

import com.bean.UserBean;
import com.dao.UserDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		if (userName!=null  && password != null) 
		{
			
			UserDao userDao = new UserDao();
			
			UserBean userBean = userDao.getUserByEmailId(userName, password);
			
			System.out.println("userBean :"+userBean);
			if(userBean != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				rd = request.getRequestDispatcher("registration.jsp");
			} else 
			{
				request.setAttribute("loginError", "<font color='red'>Invalid UserName and Password</font>");
				rd = request.getRequestDispatcher("login.jsp");
			}
			 
			
//			if ("admin".equals(userName.trim()) && ("admin".equals(password.trim()))) 
//			{
//				HttpSession session = request.getSession();
//				session.setAttribute("userName", userName);
//				rd = request.getRequestDispatcher("registration.jsp");
//			} else 
//			{
//				request.setAttribute("loginError", "<font color='red'>Invalid UserName and Password</font>");
//				rd = request.getRequestDispatcher("login.jsp");
//			}
		} else 
		{
			rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("loginError", "<font color='red'>Invalid UserName and Password</font>");
		}
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}