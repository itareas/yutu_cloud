/*
*
* @Author: zhaobc
* @Date 2019-12-15 15:09
* @Description: 
*/
package com.yutu.entity.table;

import java.io.Serializable;
import java.util.Date;

public class TLogLanding implements Serializable {
    /**
     * 主键编码
     */
    private String uuid;

    /**
     * 用户id
     */
    private String loginUserid;

    /**
     * 登录账号
     */
    private String loginAccount;

    /**
     * 登陆者的ip
     */
    private String loginIp;

    /**
     * 登陆sessionId
     */
    private String loginSessionid;

    /**
     * 登陆时间
     */
    private Date loginDate;

    /**
     * 登陆类型： 登陆/退出登录
     */
    private String loginType;

    /**
     * 登陆结果   0：登陆成功   1：登陆失败
     */
    private Integer loginResult;

    /**
     * 登录子系统/模块名称
     */
    private String loginAppname;

    /**
     * 登陆系统地址
     */
    private String loginAddress;

    /**
     * 备注
     */
    private String remarks;

    /**
     * t_log_landing
     */
    private static final long serialVersionUID = 1L;

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 主键编码
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLoginUserid() {
        return loginUserid;
    }

    /**
     * 用户id
     */
    public void setLoginUserid(String loginUserid) {
        this.loginUserid = loginUserid == null ? null : loginUserid.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLoginAccount() {
        return loginAccount;
    }

    /**
     * 登录账号
     */
    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 登陆者的ip
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLoginSessionid() {
        return loginSessionid;
    }

    /**
     * 登陆sessionId
     */
    public void setLoginSessionid(String loginSessionid) {
        this.loginSessionid = loginSessionid == null ? null : loginSessionid.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Date getLoginDate() {
        return loginDate;
    }

    /**
     * 登陆时间
     */
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLoginType() {
        return loginType;
    }

    /**
     * 登陆类型： 登陆/退出登录
     */
    public void setLoginType(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Integer getLoginResult() {
        return loginResult;
    }

    /**
     * 登陆结果   0：登陆成功   1：登陆失败
     */
    public void setLoginResult(Integer loginResult) {
        this.loginResult = loginResult;
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLoginAppname() {
        return loginAppname;
    }

    /**
     * 登录子系统/模块名称
     */
    public void setLoginAppname(String loginAppname) {
        this.loginAppname = loginAppname == null ? null : loginAppname.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLoginAddress() {
        return loginAddress;
    }

    /**
     * 登陆系统地址
     */
    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress == null ? null : loginAddress.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
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
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}