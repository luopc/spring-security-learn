package com.luopc.security.validate.sms;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.luopc.security.properties.SecurityProperties;
import com.luopc.security.validate.ValidateCode;
import com.luopc.security.validate.ValidateCodeGenerator;

@Component("smsCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator<ValidateCode> {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private SecurityProperties securityProperties;

	@Override
	public ValidateCode generate(ServletWebRequest request) {
		String code = RandomStringUtils.randomNumeric(6);
		ValidateCode smsCode = new ValidateCode(code, 60);
		log.info("生成的短信验证码为：" + code);
		return smsCode;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}

}
