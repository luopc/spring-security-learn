package com.luopc.base.center.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.luopc.base.center.user.model.Account;
@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(String accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

	Account selectByLoginName(String loginName);
}