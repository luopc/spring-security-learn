package com.luopc.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.luopc.web.model.LoginLog;

@Repository
public class LoginLogDao {
	private JdbcTemplate jdbcTemplate;

	public void insertLoginLog(LoginLog loginLog) {
		Object[] args = { loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate() };
		jdbcTemplate.update("INSERT INTO t_login_log(user_id,ip,login_date) VALUES(?,?,?)", args);
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}