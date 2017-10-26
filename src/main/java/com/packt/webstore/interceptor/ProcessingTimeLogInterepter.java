package com.packt.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProcessingTimeLogInterepter extends HandlerInterceptorAdapter { 
	/* [or] implements org.springframework.web.servlet.HandlerInterceptor */
	
	private static final Logger LOGGER = Logger.getLogger(ProcessingTimeLogInterepter.class);
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		String queryString = request.getQueryString() == null ? "" : "?" + request.getQueryString();
		String path = request.getRequestURL() + queryString;
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		LOGGER.info(String.format("%s miliseconds taken to process the request %s.", (endTime - startTime), path));
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}
	
}
