package com.luopc.security.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luopc.security.properties.SecurityProperties;
import com.luopc.security.validate.image.ImageCodeGenerator;
import com.luopc.security.validate.sms.DefaultSmsCodeSender;
import com.luopc.security.validate.sms.SmsCodeGenerator;
import com.luopc.security.validate.sms.SmsCodeSendTool;

@Configuration
public class ValidateCodeBeanConfig {

	@Autowired
	private SecurityProperties securityProperties;

	@Bean
	@ConditionalOnMissingBean(name = "imageCodeGenerator")
	public ValidateCodeGenerator imageCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}
	
	
	@Bean
	@ConditionalOnMissingBean(SmsCodeSendTool.class)
	public SmsCodeSendTool smsCodeSendTool() {
		DefaultSmsCodeSender tool = new DefaultSmsCodeSender();
		tool.setSecurityProperties(securityProperties);
		return tool;
	}

}
