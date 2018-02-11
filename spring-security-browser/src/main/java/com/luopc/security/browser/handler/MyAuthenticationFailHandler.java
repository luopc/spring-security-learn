package com.luopc.security.browser.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luopc.security.properties.LoginResponseType;
import com.luopc.security.properties.SecurityProperties;

@Component("myAuthenticationFailHandler")
public class MyAuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler{

//implements AuthenticationFailureHandler {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private SecurityProperties securityProperties;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		log.info("登陆失败");
		if(LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(objectMapper.writeValueAsString(exception));
		}else {
			super.onAuthenticationFailure(request, response, exception);
		}
		
	}

}
