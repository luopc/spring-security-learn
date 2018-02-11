package com.luopc.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.luopc.web.model.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final static String MATCH_COUNT_SQL = " SELECT count(*) FROM t_user  "
			+ " WHERE user_name =? and password=? ";
	private final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET "
			+ " last_visit=?,last_ip=?,credits=?  WHERE user_id =?";

	public int getMatchCount(String userName, String password) {
		return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[] { userName, password }, Integer.class);
	}

	public User findUserByUserId(String id) {
		String sqlStr = " SELECT user_id,user_name,credits " + " FROM t_user WHERE user_id = ? ";
		final User user =  new User();
		jdbcTemplate.query(sqlStr, new Object[] { id }, (rs)->{
			user.setUserId(rs.getString("USER_ID"));
			user.setUserName(rs.getString("USER_NAME"));
			user.setCredits(rs.getInt("CREDITS"));
		});
		return user;
	}
	
	public User findUserByUserName(final String userName) {
		String sqlStr = " SELECT user_id,user_name,credits " + " FROM t_user WHERE user_name =? ";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] { userName }, (rs) -> {
			user.setUserId(rs.getString("USER_ID"));
			user.setUserName(userName);
			user.setCredits(rs.getInt("CREDITS"));
		});
		return user;
	}

	public void updateLoginInfo(User user) {
		jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,
				new Object[] { user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId() });
	}

	public List<User> findAllUser() {
		String sql = "SELECT * FROM T_USER ";
		List<User> uList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
		return uList;
	}

	

}
