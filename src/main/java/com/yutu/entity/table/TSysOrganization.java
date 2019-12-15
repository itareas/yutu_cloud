/*
*
* @Author: zhaobc
* @Date 2019-12-15 15:09
* @Description: 
*/
package com.yutu.entity.table;

import java.io.Serializable;

public class TSysOrganization implements Serializable {
    /**
     * 编码
     */
    private String uuid;

    /**
     * 部门父类id(表格树)
     */
    private String orgParent;

    /**
     * 部门特殊编码
     */
    private String orgCode;

    /**
     * 部门名称
     */
    private String orgName;

    /**
     * 部门电话
     */
    private String orgPhone;

    /**
     * 部门地址
     */
    private String orgAddress;

    /**
     * 部门负责人
     */
    private String orgManager;

    /**
     * 部门状态 0：未锁定  1：已锁定
     */
    private Integer orgStatus;

    /**
     * 排序
     */
    private Integer orderBy;

    /**
     * 逻辑删除 0:未删除,  1:已删除
     */
    private Integer deleteStatus;

    /**
     * 备注
     */
    private String remarks;

    /**
     * t_sys_organization
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
     * 编码
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOrgParent() {
        return orgParent;
    }

    /**
     * 部门父类id(表格树)
     */
    public void setOrgParent(String orgParent) {
        this.orgParent = orgParent == null ? null : orgParent.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 部门特殊编码
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 部门名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOrgPhone() {
        return orgPhone;
    }

    /**
     * 部门电话
     */
    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone == null ? null : orgPhone.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOrgAddress() {
        return orgAddress;
    }

    /**
     * 部门地址
     */
    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOrgManager() {
        return orgManager;
    }

    /**
     * 部门负责人
     */
    public void setOrgManager(String orgManager) {
        this.orgManager = orgManager == null ? null : orgManager.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Integer getOrgStatus() {
        return orgStatus;
    }

    /**
     * 部门状态 0：未锁定  1：已锁定
     */
    public void setOrgStatus(Integer orgStatus) {
        this.orgStatus = orgStatus;
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
     * 逻辑删除 0:未删除,  1:已删除
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
        sb.append(", orgParent=").append(orgParent);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", orgName=").append(orgName);
        sb.append(", orgPhone=").append(orgPhone);
        sb.append(", orgAddress=").append(orgAddress);
        sb.append(", orgManager=").append(orgManager);
        sb.append(", orgStatus=").append(orgStatus);
        sb.append(", orderBy=").append(orderBy);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}