package com.luopc.web.center.role.dao;

import com.luopc.web.center.role.model.role;

public interface roleMapper {
    int deleteByPrimaryKey(String id);

    int insert(role record);

    int insertSelective(role record);

    role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(role record);

    int updateByPrimaryKey(role record);
}