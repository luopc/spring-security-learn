package com.luopc.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码处理器，封装不同的校验码处理逻辑
 * @author cheng
 *
 */
public interface ValidateCodeProcessor {
	
	String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";
	
	public void createCode(ServletWebRequest request) throws Exception;
	

	/**
	 * 校验验证码
	 * 
	 * @param servletWebRequest
	 * @throws Exception
	 */
	void validate(ServletWebRequest servletWebRequest);

}
