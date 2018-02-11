package com.luopc.security.validate.exception;

import org.springframework.security.core.AuthenticationException;

public class ValidateCodeException extends AuthenticationException {

	
	public ValidateCodeException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = -4754825195558934443L;

}
