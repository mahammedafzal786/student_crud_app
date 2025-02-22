package com.controller;

import java.io.IOException;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.OTPSender;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ForgetPasswordServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailid = request.getParameter("emailid");
		
		RequestDispatcher rd = null;
		if (emailid!=null) 
		{
			
			System.out.println("emailid :"+emailid);
			
			UserDao userDao = new UserDao();
			
			OTPSender otpSender = new OTPSender();
			
			
			UserBean userBean = userDao.checkEmailId(emailid);
			
			System.out.println("userBean :"+userBean);
			
			if(userBean != null) {
				HttpSession session = request.getSession();
				session.setAttribute("emailId", emailid);
				session.setAttribute("userBean", userBean);
				
				
				// Generate OTP
			 	String otp = otpSender.sendMail(emailid);
			 	
			 	session.setAttribute("otp",otp);
				
				rd = request.getRequestDispatcher("changepassword.jsp");
			} else 
			{
				request.setAttribute("Error", "<font color='red'>Email not exist!!!</font>");
				rd = request.getRequestDispatcher("forgetpassword.jsp");
			}
			 
			
		} else 
		{
			rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("loginError", "<font color='red'>Invalid UserName and Password</font>");
		}
		rd.forward(request, response);
	}
		
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
