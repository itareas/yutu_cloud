/**
* @Author: zhaobc
* @Date 2019-12-29 15:42
* @Description: 
**/
package com.yutu.entity.table;

import java.io.Serializable;
import java.util.Date;

public class TLogLanding implements Serializable {
    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 主键编码
    **/
    private String uuid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 用户id
    **/
    private String loginUserid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 登录账号
    **/
    private String loginAccount;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 登陆者的ip
    **/
    private String loginIp;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 登陆sessionId
    **/
    private String loginSessionid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 登陆时间
    **/
    private Date loginDate;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 登陆类型： 登陆/退出登录
    **/
    private String loginType;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 登陆结果   0：登陆成功   1：登陆失败
    **/
    private Integer loginResult;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 登录子系统/模块名称
    **/
    private String loginAppname;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 登陆系统地址
    **/
    private String loginAddress;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: appKey
    **/
    private String appkey;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: token
    **/
    private String token;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 备注
    **/
    private String remarks;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: t_log_landing
    **/
    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getLoginUserid() {
        return loginUserid;
    }

    public void setLoginUserid(String loginUserid) {
        this.loginUserid = loginUserid == null ? null : loginUserid.trim();
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getLoginSessionid() {
        return loginSessionid;
    }

    public void setLoginSessionid(String loginSessionid) {
        this.loginSessionid = loginSessionid == null ? null : loginSessionid.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    public Integer getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(Integer loginResult) {
        this.loginResult = loginResult;
    }

    public String getLoginAppname() {
        return loginAppname;
    }

    public void setLoginAppname(String loginAppname) {
        this.loginAppname = loginAppname == null ? null : loginAppname.trim();
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress == null ? null : loginAddress.trim();
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey == null ? null : appkey.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", loginUserid=").append(loginUserid);
        sb.append(", loginAccount=").append(loginAccount);
        sb.append(", loginIp=").append(loginIp);
        sb.append(", loginSessionid=").append(loginSessionid);
        sb.append(", loginDate=").append(loginDate);
        sb.append(", loginType=").append(loginType);
        sb.append(", loginResult=").append(loginResult);
        sb.append(", loginAppname=").append(loginAppname);
        sb.append(", loginAddress=").append(loginAddress);
        sb.append(", appkey=").append(appkey);
        sb.append(", token=").append(token);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}