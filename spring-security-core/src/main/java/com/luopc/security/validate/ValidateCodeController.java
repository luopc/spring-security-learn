package com.luopc.security.validate;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
/**
 * 验证码处理方法
 * @author cheng
 *
 */
@RestController
public class ValidateCodeController {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private Map<String, ValidateCodeProcessor> validateCodeProcessors;

	@GetMapping("/code/{type}")
	public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type)
			throws Exception {
		log.info("跳转的方法名是：" + type);
		validateCodeProcessors.get(type + "ValidateCodeProcessor").createCode(new ServletWebRequest(request, response));
	}

}
