package com.luopc.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;
import com.luopc.web.validator.MyUserConstraint;

public class User implements Serializable {

	public interface UserSimpleView {
	};

	public interface UserDetailView extends UserSimpleView {
	};

	private static final long serialVersionUID = 8145279410934787263L;
	private String userId;
	@NotNull(message = "用户名不能为空")
	private String userName;
	private int credits;
	@NotNull(message = "密码不能为空")
	private String password;
	private Date lastVisit;
	private String lastIp;
	@MyUserConstraint
	private String salt;

	public User() {
		super();
	}

	public User(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	@JsonView(UserSimpleView.class)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonView(UserSimpleView.class)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonView(UserSimpleView.class)
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonView(UserSimpleView.class)
	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	@JsonView(UserSimpleView.class)
	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	@JsonView(UserDetailView.class)
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", lastVisit=" + lastVisit + "]";
	}

}
