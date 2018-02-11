package com.luopc.security.browser.session;

import java.io.IOException;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

public class MyExpiredSessionStrategy implements SessionInformationExpiredStrategy {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent eventØ) throws IOException, ServletException {
		log.info("并发登陆导致超时！");
		eventØ.getResponse().getWriter().write("并发登陆导致超时！");
	}

}
