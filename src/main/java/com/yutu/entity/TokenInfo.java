package com.yutu.entity;

import com.yutu.entity.api.ApiUser;

import java.util.Date;

public class TokenInfo {
	private String token;// token
	private String roleId;// 权限id
	private Date expirationDate;// 过期时间
	private ApiUser apiUser;// 是否已登陆

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}