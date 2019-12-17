/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.entity.table;

import java.io.Serializable;

public class TSysOrganization implements Serializable {
    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 编码
    **/
    private String uuid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 部门父类id(表格树)
    **/
    private String orgParent;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 部门特殊编码
    **/
    private String orgCode;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 部门名称
    **/
    private String orgName;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 部门电话
    **/
    private String orgPhone;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 部门地址
    **/
    private String orgAddress;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 部门负责人
    **/
    private String orgManager;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 部门状态 0：未锁定  1：已锁定
    **/
    private Integer orgStatus;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 排序
    **/
    private Integer orderBy;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 逻辑删除 0:未删除,  1:已删除
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
    * @Description: t_sys_organization
    **/
    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getOrgParent() {
        return orgParent;
    }

    public void setOrgParent(String orgParent) {
        this.orgParent = orgParent == null ? null : orgParent.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone == null ? null : orgPhone.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    public String getOrgManager() {
        return orgManager;
    }

    public void setOrgManager(String orgManager) {
        this.orgManager = orgManager == null ? null : orgManager.trim();
    }

    public Integer getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(Integer orgStatus) {
        this.orgStatus = orgStatus;
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