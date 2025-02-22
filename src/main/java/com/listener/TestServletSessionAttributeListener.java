package com.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;


public class TestServletSessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent se) 
	{
		System.out.println("TestServletSessionAttributeListener : attributeAdded()");
	}
	
	public void attributeReplaced(HttpSessionBindingEvent se) 
	{
		System.out.println("TestServletSessionAttributeListener : attributeReplaced()");
		
	}
	public void attributeRemoved(HttpSessionBindingEvent se) 
	{
		System.out.println("TestServletSessionAttributeListener : attributeRemoved()");
	}
	
}
