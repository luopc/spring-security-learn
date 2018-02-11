package com.luopc.auth.shiro.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CredentialMatcher extends SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String passWord = new String(usernamePasswordToken.getPassword());
		String dbPassWord = (String) info.getCredentials();
		return this.equals(passWord, dbPassWord);
	}

}
