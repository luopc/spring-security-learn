package com.luopc.base.center.resource.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.luopc.base.center.resource.model.Resource;
@Mapper
public interface ResourceMapper {
	int deleteByPrimaryKey(String resId);

	int insert(Resource record);

	int insertSelective(Resource record);

	Resource selectByPrimaryKey(String resId);

	int updateByPrimaryKeySelective(Resource record);

	int updateByPrimaryKey(Resource record);

	Set<Resource> selectResourceCollectionByRoleId(String id);
}