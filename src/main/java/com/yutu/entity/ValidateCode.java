package com.yutu.entity;
/**
 * 验证码实体类
 * @author CKQ
 *
 */
public class ValidateCode {
	private long insertTime;
	private Integer expireTime;
	private String validateCode;
	public ValidateCode(Integer expireTime,String validateCode,long insertTime){
		this.expireTime=expireTime;
		this.validateCode=validateCode;
		this.insertTime=insertTime;
	}
	public Integer getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public long getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(long insertTime) {
		this.insertTime = insertTime;
	}
	
}
