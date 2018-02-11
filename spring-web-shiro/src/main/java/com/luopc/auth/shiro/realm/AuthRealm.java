package com.luopc.auth.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.luopc.base.center.resource.model.Resource;
import com.luopc.base.center.role.model.Role;
import com.luopc.base.center.user.model.Account;
import com.luopc.base.center.user.model.UserWithRoles;
import com.luopc.service.center.user.AccountService;
import com.luopc.service.center.user.UserService;

public class AuthRealm extends AuthorizingRealm {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		Account account = (Account) principals.fromRealm(this.getClass().getName()).iterator().next();
		Set<String> permissionList = new HashSet<String>();
		Set<String> roleNameList = new HashSet<String>();
		log.info("--------------开始授权：name=" + account.getLoginName() + ";ID=" + account.getAccountId()+ "-------------------------------");
		
		UserWithRoles user = userService.findAllRoleByUserId(account.getAccountId());
		
//		List<Role> roleSet = roleService.selectRoleCollectionByUserId(account.getAccountId());
		Set<Role> roleSet = user.getRoles();
		if (CollectionUtils.isNotEmpty(roleSet)) {
			for (Role role : roleSet) {
				roleNameList.add(role.getCode());
//				Set<Resource> resSet = resourceService.selectResourceCollectionByRoleId(role.getRoleId());
				Set<Resource> resSet = role.getResources();
				if (CollectionUtils.isNotEmpty(resSet)) {
					for (Resource resources : resSet) {
						permissionList.add(resources.getName());
					}
				}
			}
		}
		log.info("获取到的角色总数为：" + roleNameList.size());
		log.info("获取到的权限总数为：" + permissionList.size());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addStringPermissions(permissionList);
		info.addRoles(roleNameList);
		return info;
	}

	/**
	 * 登陆
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String loginName = usernamePasswordToken.getUsername();
		Account account = accountService.findAccountByLoginName(loginName);
		System.out.println(account);
		return new SimpleAuthenticationInfo(account, account.getPassword(), this.getClass().getName());
	}

}
