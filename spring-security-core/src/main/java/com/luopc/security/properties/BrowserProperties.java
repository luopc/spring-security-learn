package com.luopc.security.properties;

public class BrowserProperties {

	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;
	
	public String sessionPage = "/session/invalid.html";

	private LoginResponseType loginType = LoginResponseType.JSON;
	
	private int rememberMeSeconds = 3600;

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public LoginResponseType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginResponseType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}

	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}

	public String getSessionPage() {
		return sessionPage;
	}

	public void setSessionPage(String sessionPage) {
		this.sessionPage = sessionPage;
	}
	
}
