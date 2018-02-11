package com.luopc.service.center.user;

import com.luopc.base.center.user.model.User;

public interface UserService {
	
	User findUserByLoginName(String loginName);

}
