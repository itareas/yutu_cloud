package com.yutu.entity;

import java.util.Date;

public class TokenInfo {
	private String token;// token
	private String userId;// 用户编号
	private Date expirationDate;// 过期时间
	private String isLogin;// 是否已登陆
	private String userName;  
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(String isLogin) {
		isLogin = isLogin;
	}
	
	
 
}