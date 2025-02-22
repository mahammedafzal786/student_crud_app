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

public class ChangePasswordServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try{
		String otp = request.getParameter("otp");
		String password = request.getParameter("password");
		
		RequestDispatcher rd = null;
		if (otp!=null && password != null) 
		{
			
			System.out.println("otp :"+otp);
			System.out.println("password :"+password);
			
			UserDao userDao = new UserDao();
			
			
			 
	        HttpSession session = request.getSession(false);
	        
	        
	    
			String otpMail = (String) session.getAttribute("otp");

			UserBean userBean1 = (UserBean) session.getAttribute("userBean");
		
			//validate OTP
			if(otp.equals(otpMail)) {
				
			int userBean = userDao.updatePssword(userBean1, password);
		
			System.out.println("userBean :"+userBean1);
				
			if(userBean > 0) {
				
				rd = request.getRequestDispatcher("login.jsp");
				
			} else 
			{
				request.setAttribute("Error", "<font color='red'>Please Enter Correct OTP!!!</font>");
				rd = request.getRequestDispatcher("changepassword.jsp");
			}
			}
			
		} else 
		{

			request.setAttribute("Error", "<font color='red'>Please Enter Password and  OTP!!!</font>");
			rd = request.getRequestDispatcher("chanepassword.jsp");
		}
		rd.forward(request, response);
		
		}catch (Exception e) {
			request.setAttribute("Error", "<font color='red'>Please Enter Correct OTP!!!</font>");

			e.printStackTrace();
			
			System.out.println("OTO incorrect!!!");
			
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
	
}
