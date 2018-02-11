package com.luopc.web.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luopc.base.center.user.model.User;
import com.luopc.service.center.user.UserService;

@RestController
@RequestMapping("/loginAuthen")
public class LoginAuthenController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	private UserService userService;

	@PostMapping
	public User login(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {
		String loginName = ServletRequestUtils.getRequiredStringParameter(request, "loginName");
		log.info("loginName:" + loginName);
		User user = userService.findUserByLoginName(loginName);
		return user;
	}

	@GetMapping
	public void loginIng(HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		log.info("get method is miss");
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
