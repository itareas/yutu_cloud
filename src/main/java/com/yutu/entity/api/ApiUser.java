/**
 * @Author: zhaobc
 * @Date 2019-12-16 22:26
 * @Description:
 **/
package com.yutu.entity.api;

import java.io.Serializable;

public class ApiUser implements Serializable {
    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description: 主键
     **/
    private String uuid;

    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description: 用户特殊编码
     **/
    private String userCode;

    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description: 用户登陆名
     **/
    private String userAccount;


    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description: 用户真实姓名
     **/
    private String userName;

    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description: 用户性别  0：保密   1：男   2：女'
     **/
    private String userSex;

    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description: 用户职称
     **/
    private String userTitle;

    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description: 手机号
     **/
    private String userPhone;

    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description: 用户邮件
     **/
    private String userEmail;


    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description: 备注
     **/
    private String remarks;

    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description: t_sys_user
     **/
    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle == null ? null : userTitle.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * @Author: zhaobc
     * @Date 2019-12-16 22:26
     * @Description:
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", userCode=").append(userCode);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", userName=").append(userName);
        sb.append(", userSex=").append(userSex);
        sb.append(", userTitle=").append(userTitle);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}