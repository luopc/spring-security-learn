package com.luopc.base.center.resources.dao;

import com.luopc.base.center.resources.model.LinkRoleResource;

public interface LinkRoleResourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(LinkRoleResource record);

    int insertSelective(LinkRoleResource record);

    LinkRoleResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LinkRoleResource record);

    int updateByPrimaryKey(LinkRoleResource record);
}