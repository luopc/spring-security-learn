package com.luopc.common.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


//@Component
public class TimeFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("My timeFilter destroy");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("My timeFilter start");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		System.out.println("time filter: " +  (new Date().getTime() - start));
		System.out.println("My timeFilter finish");

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("My timeFilter init");

	}

}
