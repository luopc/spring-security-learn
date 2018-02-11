package com.luopc.base.center.user.model;

import java.util.Date;

public class Account {
    private String accountId;

    private String name;

    private String loginName;

    private String salt;

    private String openId;

    private String openSecret;

    private Short isTemporary;

    private Date startDate;

    private Date endDate;

    private Short status;

    private Short approvalStatus;

    private String createUser;

    private String modifyUser;

    private String tenantId;

    private Date createTime;

    private Date modifyTime;

    private String password;

    private String email;

    private String validataCode;

    private Date validataOutDate;

    private String lastLoginIp;

    private Date lastLoginDate;

    private Date loginTime;

    private Date modifyPasswordTime;

    private Date beginValidTime;

    private Date endValidTime;

    private String identityId;

    private Short isSuperadmin;

    private String unitId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getOpenSecret() {
        return openSecret;
    }

    public void setOpenSecret(String openSecret) {
        this.openSecret = openSecret == null ? null : openSecret.trim();
    }

    public Short getIsTemporary() {
        return isTemporary;
    }

    public void setIsTemporary(Short isTemporary) {
        this.isTemporary = isTemporary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Short approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getValidataCode() {
        return validataCode;
    }

    public void setValidataCode(String validataCode) {
        this.validataCode = validataCode == null ? null : validataCode.trim();
    }

    public Date getValidataOutDate() {
        return validataOutDate;
    }

    public void setValidataOutDate(Date validataOutDate) {
        this.validataOutDate = validataOutDate;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getModifyPasswordTime() {
        return modifyPasswordTime;
    }

    public void setModifyPasswordTime(Date modifyPasswordTime) {
        this.modifyPasswordTime = modifyPasswordTime;
    }

    public Date getBeginValidTime() {
        return beginValidTime;
    }

    public void setBeginValidTime(Date beginValidTime) {
        this.beginValidTime = beginValidTime;
    }

    public Date getEndValidTime() {
        return endValidTime;
    }

    public void setEndValidTime(Date endValidTime) {
        this.endValidTime = endValidTime;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId == null ? null : identityId.trim();
    }

    public Short getIsSuperadmin() {
        return isSuperadmin;
    }

    public void setIsSuperadmin(Short isSuperadmin) {
        this.isSuperadmin = isSuperadmin;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId == null ? null : unitId.trim();
    }

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name + ", loginName=" + loginName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", email=" + email + ", unitId=" + unitId + "]";
	}
}