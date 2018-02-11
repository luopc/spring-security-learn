/**
 * 
 */
package com.luopc.security.validate;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码、短信码生成器
 * 
 * @author cheng
 */
public interface ValidateCodeGenerator<C extends ValidateCode>{

	C generate(ServletWebRequest request);

}
