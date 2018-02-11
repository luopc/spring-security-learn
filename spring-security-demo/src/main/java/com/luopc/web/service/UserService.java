package com.luopc.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luopc.web.dao.LoginLogDao;
import com.luopc.web.dao.UserDao;
import com.luopc.web.model.LoginLog;
import com.luopc.web.model.User;

@Service
public class UserService {

	private UserDao userDao;

	private LoginLogDao loginLogDao;

	public boolean hasMatchUser(String userName, String password) {
		int match = userDao.getMatchCount(userName, password);
		return match > 0;
	}

	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	

	public User findUserByUserId(String id) {
		return userDao.findUserByUserId(id);
	}
	
	public List<User> findAllUser() {
//		List<User> uList =  new ArrayList<User>();
//		User u = new User();
//		u.setUserId("100001");
//		u.setUserName("admin");
//		u.setCredits(12);
//		u.setLastVisit(new Date());
//		u.setLastIp("127.0.0.1");
//		uList.add(u);
		return userDao.findAllUser();
	}

	@Transactional
	public void loginSuccess(User user) {
		user.setCredits(5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);

	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Autowired
	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao = loginLogDao;
	}




}
