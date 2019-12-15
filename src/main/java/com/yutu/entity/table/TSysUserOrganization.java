/*
*
* @Author: zhaobc
* @Date 2019-12-15 15:09
* @Description: 
*/
package com.yutu.entity.table;

import java.io.Serializable;

public class TSysUserOrganization implements Serializable {
    /**
     * 编码
     */
    private String uuid;

    /**
     * 部门uuid
     */
    private String orgUuid;

    /**
     * 用户uuid
     */
    private String userUuid;

    /**
     * 备注
     */
    private String remarks;

    /**
     * t_sys_user_organization
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
    public String getOrgUuid() {
        return orgUuid;
    }

    /**
     * 部门uuid
     */
    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid == null ? null : orgUuid.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getUserUuid() {
        return userUuid;
    }

    /**
     * 用户uuid
     */
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
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
        sb.append(", orgUuid=").append(orgUuid);
        sb.append(", userUuid=").append(userUuid);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}