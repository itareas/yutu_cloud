package com.yutu.entity;

import com.yutu.entity.api.ApiUser;

import java.util.Date;

public class TokenInfo {
	private String token;// token
	private String appkey;// appkey
	private String roleId;// 权限id
	private String security; //安全验证码
	private Date expirationDate;// 过期时间
	private ApiUser apiUser;// 是否已登陆

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public ApiUser getApiUser() {
		return apiUser;
	}

	public void setApiUser(ApiUser apiUser) {
		this.apiUser = apiUser;
	}
}