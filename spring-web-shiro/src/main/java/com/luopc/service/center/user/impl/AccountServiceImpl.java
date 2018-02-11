package com.luopc.service.center.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luopc.base.center.user.dao.AccountMapper;
import com.luopc.base.center.user.model.Account;
import com.luopc.service.center.user.AccountService;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public Account findAccountByLoginName(String loginName) {
		return accountMapper.selectByLoginName(loginName);
	}

	
}
