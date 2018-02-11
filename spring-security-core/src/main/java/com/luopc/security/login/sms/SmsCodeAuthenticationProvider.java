package com.luopc.security.login.sms;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

	private UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		SmsCodeAuthenticationToken token = (SmsCodeAuthenticationToken) authentication;
		UserDetails user = userDetailsService.loadUserByUsername((String) token.getPrincipal());
		if (user == null) {
			throw new InternalAuthenticationServiceException("无法获取用户信息");
		}
		SmsCodeAuthenticationToken reslut = new SmsCodeAuthenticationToken(user, user.getAuthorities());
		reslut.setDetails(token.getAuthorities());
		return reslut;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	

}
