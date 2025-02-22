package com.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;


public class TestServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) 
	{
		System.out.println("TestServletContextListener--contextInitialized()");
	}
	public void contextDestroyed(ServletContextEvent sce) 
	{
		System.out.println("TestServletContextListener--contextDestroyed()");
	}
}
