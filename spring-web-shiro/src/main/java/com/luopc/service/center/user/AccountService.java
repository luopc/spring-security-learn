package com.luopc.service.center.user;

import com.luopc.base.center.user.model.Account;

public interface AccountService {
	
	Account findAccountByLoginName(String loginName);

}
