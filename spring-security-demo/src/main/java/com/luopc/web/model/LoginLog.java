package com.luopc.web.model;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable{

    private String loginLogId;

    private String userId;

    private String ip;

    private Date loginDate;

    public String getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(String loginLogId) {
        this.loginLogId = loginLogId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
