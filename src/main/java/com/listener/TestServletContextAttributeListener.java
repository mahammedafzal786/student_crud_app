package com.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;


public class TestServletContextAttributeListener implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent scae) 
	{
		System.out.println("TestServletContextAttributeListener : attributeAdded()");
	}
	public void attributeReplaced(ServletContextAttributeEvent scae) 
	{
		System.out.println("TestServletContextAttributeListener : attributeReplaced()");
	}
	public void attributeRemoved(ServletContextAttributeEvent scae) 
	{
		System.out.println("TestServletContextAttributeListener : attributeRemoved()");
	}
	
}
