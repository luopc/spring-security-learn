package com.luopc.base.center.user.dao;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.luopc.base.center.role.dao.RoleMapper;
import com.luopc.base.center.user.model.Account;
import com.luopc.base.center.user.model.UserWithRoles;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTest {
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private RoleMapper roleMapper;

	@Test
	public void testInsertAccountTest() {
		Account account = new Account();
		account.setName("超级管理员");
		account.setLoginName("admin");
		account.setPassword("123456");
		account.setEmail("admin@163.com");
		account.setLastLoginDate(new Date());
		//int rs = accountMapper.insertAccountTest(account);
//		System.out.println(rs);
	}

	@Test
	public void testSelectRoleCoolections() {
		Set<Map<String, Object>> lists = roleMapper.selectRoleCoolectionsMapByUserId("10086");
		for (Map<String, Object> map : lists) {
			for (Map.Entry<String, Object> data : map.entrySet()) {
				System.out.println(data.getKey() + ":" + data.getValue());
			}
		}
	}
	
	

}
