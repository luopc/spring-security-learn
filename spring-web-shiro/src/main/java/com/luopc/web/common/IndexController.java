package com.luopc.web.common;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luopc.base.center.user.model.Account;

@Controller
public class IndexController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String edit() {
		return "edit success";
	}

	@RequestMapping("logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null)
			subject.logout();
		return "login";
	}

	@RequestMapping("/admin")
	@ResponseBody
	public String admin() {
		return "admin success";
	}

	@RequestMapping("/loginUser")
	public String loginUser(@RequestParam("username") String userName, @RequestParam("password") String password,
			HttpSession httpSession) {
		log.info("username:" + userName);
		log.info("password:" + password);
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			Account account = (Account) subject.getPrincipal();
			log.info("user:" + account);
			httpSession.setAttribute("user", account);
			return "index";
		} catch (AuthenticationException e) {
			// e.printStackTrace();
		}
		return "login";
	}

}
