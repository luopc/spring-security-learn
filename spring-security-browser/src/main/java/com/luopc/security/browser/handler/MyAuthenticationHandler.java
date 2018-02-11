package com.luopc.security.browser.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luopc.security.properties.LoginResponseType;
import com.luopc.security.properties.SecurityProperties;

@Component("myAuthenticationHandler")
public class MyAuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	// implements AuthenticationSuccessHandler{

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("登陆成功");
		if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(objectMapper.writeValueAsString(authentication));
		} else {
			super.onAuthenticationSuccess(request, response, authentication);
		}

	}

}
