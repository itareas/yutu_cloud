/*
*
* @Author: zhaobc
* @Date 2019-12-15 15:09
* @Description: 
*/
package com.yutu.entity.table;

import java.io.Serializable;

public class TSysUser implements Serializable {
    /**
     * 主键
     */
    private String uuid;

    /**
     * 用户特殊编码
     */
    private String userCode;

    /**
     * 用户登陆名
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String userPwd;

    /**
     * 密码提示
     */
    private String userQuestion;

    /**
     * 用户真实姓名
     */
    private String userName;

    /**
     * 用户性别  0：保密   1：男   2：女'
     */
    private Integer userSex;

    /**
     * 用户职称
     */
    private String userTitle;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 用户邮件
     */
    private String userEmail;

    /**
     * 用户锁定  0：正常   1：锁定
     */
    private Integer userStatus;

    /**
     * 排序
     */
    private Integer orderBy;

    /**
     * 用户逻辑删除  0 ：正常   1：删除
     */
    private Integer deleteStatus;

    /**
     * 备注
     */
    private String remarks;

    /**
     * t_sys_user
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
     * 主键
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 用户特殊编码
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * 用户登陆名
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 用户密码
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getUserQuestion() {
        return userQuestion;
    }

    /**
     * 密码提示
     */
    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion == null ? null : userQuestion.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户真实姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * 用户性别  0：保密   1：男   2：女'
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getUserTitle() {
        return userTitle;
    }

    /**
     * 用户职称
     */
    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle == null ? null : userTitle.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 用户邮件
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 用户锁定  0：正常   1：锁定
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Integer getOrderBy() {
        return orderBy;
    }

    /**
     * 排序
     */
    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 用户逻辑删除  0 ：正常   1：删除
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
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