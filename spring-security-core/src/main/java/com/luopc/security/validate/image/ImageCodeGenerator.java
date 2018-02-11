package com.luopc.security.validate.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.luopc.security.properties.SecurityProperties;
import com.luopc.security.validate.ValidateCodeGenerator;
/**
 * 
 * @author cheng
 *
 */
public class ImageCodeGenerator implements ValidateCodeGenerator<ImageCode> {

	private Logger log = LoggerFactory.getLogger(getClass());

	private SecurityProperties securityProperties;

	@Override
	public ImageCode generate(ServletWebRequest request) {
		int w = ServletRequestUtils.getIntParameter(request.getRequest(), "width",
				securityProperties.getCode().getImage().getWidth());
		log.info("width:" + String.valueOf(w));
		int h = ServletRequestUtils.getIntParameter(request.getRequest(), "height",
				securityProperties.getCode().getImage().getHeight());
		int l = securityProperties.getCode().getImage().getLength();
		ImageCodeGeneratorTool verifyCode = new ImageCodeGeneratorTool(w, h, l);
		ImageCode code = new ImageCode(verifyCode.createImage(), verifyCode.getText(),
				securityProperties.getCode().getImage().getExpireIn());
		return code;
	}

	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}

}
