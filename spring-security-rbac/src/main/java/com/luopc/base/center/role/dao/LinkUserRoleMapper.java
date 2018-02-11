package com.luopc.base.center.role.dao;

import com.luopc.base.center.role.model.LinkUserRole;

public interface LinkUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(LinkUserRole record);

    int insertSelective(LinkUserRole record);

    LinkUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LinkUserRole record);

    int updateByPrimaryKey(LinkUserRole record);
}