/**
 * 
 */
package com.luopc.security.validate.image;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.luopc.security.validate.ValidateCodeProcessor;
import com.luopc.security.validate.exception.ValidateCodeException;
import com.luopc.security.validate.impl.AbstractValidateCodeProcessor;

/**
 * 图片验证码处理器
 * 
 * @author zhailiang
 *
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

	/**
	 * 发送图形验证码，将其写到响应中
	 */
	@Override
	protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
		ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
	}


}
