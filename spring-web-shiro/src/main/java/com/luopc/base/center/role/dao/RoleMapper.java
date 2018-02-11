package com.luopc.base.center.role.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.luopc.base.center.role.model.Role;

@Mapper
public interface RoleMapper {
	int deleteByPrimaryKey(String roleId);

	int insert(Role record);

	int insertSelective(Role record);

	Role selectByPrimaryKey(String roleId);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);

	List<Role> selectRoleCoolectionsByUserId(String id);

	Set<Map<String, Object>> selectRoleCoolectionsMapByUserId(String id);

	List<Role> selectAllRoles();
}