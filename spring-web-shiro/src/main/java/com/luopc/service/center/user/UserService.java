package com.luopc.service.center.user;

import com.luopc.base.center.user.model.User;
import com.luopc.base.center.user.model.UserWithRoles;

public interface UserService {
	
	User findUserByLoginName(String loginName);
	
	UserWithRoles findAllRoleByUserId(String userId);

}
