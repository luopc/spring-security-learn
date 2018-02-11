package com.luopc.service.center.role.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luopc.base.center.role.dao.RoleMapper;
import com.luopc.base.center.role.model.Role;
import com.luopc.service.center.role.RoleService;
@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> selectRoleCollectionByUserId(String id) {
		return roleMapper.selectRoleCoolectionsByUserId(id);
	}

	@Override
	public List<Role> selectAllRoles() {
		return roleMapper.selectAllRoles();
	}

}
