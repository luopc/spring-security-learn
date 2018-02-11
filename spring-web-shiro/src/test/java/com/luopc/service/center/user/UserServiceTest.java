package com.luopc.service.center.user;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.luopc.base.center.resource.model.Resource;
import com.luopc.base.center.role.model.Role;
import com.luopc.base.center.user.model.User;
import com.luopc.service.center.resources.ResourceService;
import com.luopc.service.center.role.RoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;

	@Test
	public void testFindUserByLoginName() {
		User u = userService.findUserByLoginName("张三");
		assertEquals(u.getLoginName(), "张三");
	}

	
	@Test
	public void testSelectRoleCollectionByUserId() {
		List<Role> roleList = roleService.selectRoleCollectionByUserId("10086");
		System.out.println(roleList.size());
	}
	
	@Test
	public void testSelectAllRoles() {
		List<Role> roleList = roleService.selectAllRoles();
		System.out.println(roleList.size());
	}
	
	@Test
	public void testSelectResourceCollectionByRoleId() {
		Set<Resource> resourcesList = resourceService.selectResourceCollectionByRoleId("1001");
		System.out.println(resourcesList.size());
	}
}
