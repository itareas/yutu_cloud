/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.entity.table;

import java.io.Serializable;

public class TSysUser implements Serializable {
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
    * @Description: 用户密码
    **/
    private String userPwd;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 密码提示
    **/
    private String userQuestion;

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
    private Integer userSex;

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
    * @Description: 用户锁定  0：正常   1：锁定
    **/
    private Integer userStatus;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 排序
    **/
    private Integer orderBy;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 用户逻辑删除  0 ：正常   1：删除
    **/
    private Integer deleteStatus;

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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion == null ? null : userQuestion.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
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

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
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
        sb.append(", userPwd=").append(userPwd);
        sb.append(", userQuestion=").append(userQuestion);
        sb.append(", userName=").append(userName);
        sb.append(", userSex=").append(userSex);
        sb.append(", userTitle=").append(userTitle);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", orderBy=").append(orderBy);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}