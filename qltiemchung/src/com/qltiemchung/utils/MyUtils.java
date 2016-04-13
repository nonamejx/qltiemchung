package com.qltiemchung.utils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qltiemchung.model.bean.MessageBundle;

public class MyUtils {
	
	/**
	 * <h1>forward</h1> Chuyen trang
	 * 
	 * @param servletContext
	 * @param request
	 * @param response
	 * @param url
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */
	public static void forward(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		RequestDispatcher rd = servletContext.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
	public static void appendMessageBundle(HttpServletRequest request, MessageBundle bundle) {
		MessageBundle messageBundle = (MessageBundle) request.getAttribute("MessageBundleQLVX");
		if (messageBundle == null) {
			messageBundle = new MessageBundle();
			messageBundle.put(bundle);
		} else {
			messageBundle.put(bundle);
		}
		
		request.setAttribute("MessageBundleQLVX", messageBundle);
	}
	
	public static void putMessageBundle(HttpServletRequest request, MessageBundle bundle) {
		MessageBundle messageBundle = new MessageBundle();
		messageBundle.put(bundle);
		
		request.setAttribute("MessageBundleQLVX", messageBundle);
	}
	
	public static MessageBundle getMessageBundle(HttpServletRequest request) {
		MessageBundle messageBundle = (MessageBundle) request.getAttribute("MessageBundleQLVX");
		if (messageBundle == null) return new MessageBundle();
		return messageBundle;
	}
	
	public static void sendRedirect(HttpServletResponse response) {
		
	}
	
	
}
