/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.entity.table;

import java.io.Serializable;

public class TSysRoleMenubus implements Serializable {
    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 编码
    **/
    private String uuid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 角色uuid
    **/
    private String roleUuid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 业务菜单uuid
    **/
    private String menubusUuid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 备注
    **/
    private String remarks;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: t_sys_role_menubus
    **/
    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getRoleUuid() {
        return roleUuid;
    }

    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid == null ? null : roleUuid.trim();
    }

    public String getMenubusUuid() {
        return menubusUuid;
    }

    public void setMenubusUuid(String menubusUuid) {
        this.menubusUuid = menubusUuid == null ? null : menubusUuid.trim();
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
        sb.append(", roleUuid=").append(roleUuid);
        sb.append(", menubusUuid=").append(menubusUuid);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}