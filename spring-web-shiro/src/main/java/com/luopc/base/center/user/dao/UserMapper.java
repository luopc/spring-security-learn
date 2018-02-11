package com.luopc.base.center.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.luopc.base.center.user.model.User;
import com.luopc.base.center.user.model.UserWithRoles;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectByLoginName(String loginName);
    
    UserWithRoles findAllRoleByUserId(String userId);
}