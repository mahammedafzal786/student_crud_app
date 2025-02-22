package com.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class TestServletRequestListener implements ServletRequestListener{
	
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		
		System.out.println("TestServletRequestListener----requestInitialized()");
	
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
		System.out.println("TestServletRequestListener----requestDestroyed()");
	}
	
	
}
