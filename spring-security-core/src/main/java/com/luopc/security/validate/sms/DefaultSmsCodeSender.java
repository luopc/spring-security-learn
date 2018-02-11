package com.luopc.security.validate.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luopc.security.properties.SecurityProperties;

public class DefaultSmsCodeSender implements SmsCodeSendTool {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	private SecurityProperties securityProperties;//从里面读取短信平台的配置

	@Override
	public void send(String mobile, String code) {
		log.info("向手机【" + mobile + "】发送了验证码:" + code + "。");
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}

}
