package com.listener;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;


public class TestServletSessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) 
	{
		System.out.println("TestServletSessionListener : sessionCreated()");
	}
	public void sessionDestroyed(HttpSessionEvent se) 
	{
		System.out.println("TestServletSessionListener : sessionDestroyed()");
	}
	
}
