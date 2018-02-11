package com.luopc.common.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//@Component
public class TimeInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		System.out.println("time Interceptor preHandle");
		System.out.println(((HandlerMethod)obj).getMethod().getName());
		request.setAttribute("startTime", new Date().getTime());
		return true;
	}
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView arg3)
			throws Exception {
		System.out.println("time Interceptor postHandle");
		Long startTime = (Long) request.getAttribute("startTime");
		System.out.println("time interceptor postHandle 耗时：" + (new Date().getTime() - startTime));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception exc)
			throws Exception {
		System.out.println("time Interceptor afterCompletion");
		Long startTime = (Long) request.getAttribute("startTime");
		System.out.println("time interceptor afterCompletion 耗时：" + (new Date().getTime() - startTime));
		System.out.println("");
	}


	

}
