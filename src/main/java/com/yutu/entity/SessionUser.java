package com.yutu.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2019/5/6 17:08
 * @Description: Session存储模板
 **/
public class SessionUser implements Serializable {
    private static final long serialVersionUID = -1468878707556152647L;

    private String sessionId;
    private String uuid;
    private String userAccount;
    private String userName;
    private String userSafety;
    private String roleId;
    private String orgId;
    private String menu;
    private String token;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSafety() {
        return userSafety;
    }

    public void setUserSafety(String userSafety) {
        this.userSafety = userSafety;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
