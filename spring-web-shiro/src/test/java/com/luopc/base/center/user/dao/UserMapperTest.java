package com.luopc.base.center.user.dao;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.luopc.base.center.user.model.UserWithRoles;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testfindAllRoleByUserId() {
		UserWithRoles user = userMapper.findAllRoleByUserId("DBEF32CAC64942D8841168C792B35B9B");
		System.out.println(user.getRoles().size());
	}

	@Test
	public void createSQL() {
		SQL sql = new SQL().SELECT(" * ").FROM("t_user").WHERE("user_id = ? or login_name = ? ").AND().WHERE("states = 1").getSelf();
		System.out.println(sql.toString());
		
		
	}
}
