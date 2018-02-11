package com.luopc.service.center.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luopc.base.center.user.dao.UserMapper;
import com.luopc.base.center.user.model.User;
import com.luopc.base.center.user.model.UserWithRoles;
import com.luopc.service.center.user.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByLoginName(String loginName) {
		return userMapper.selectByLoginName(loginName);
	}

	@Override
	public UserWithRoles findAllRoleByUserId(String userId) {
		return userMapper.findAllRoleByUserId(userId);
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
