/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.entity.table;

import java.io.Serializable;
import java.util.Date;

public class TCodConfig implements Serializable {
    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 编码
    **/
    private String uuid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 配置编码
    **/
    private String configCode;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 配置名称
    **/
    private String configName;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 配置父类
    **/
    private String configParent;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 配置等级
    **/
    private Integer configLevel;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 配置状态：0:关闭；1:开启
    **/
    private Integer configStatus;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 排序
    **/
    private Integer orderBy;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 更新时间
    **/
    private Date updateTime;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 备注
    **/
    private String remarks;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: t_cod_config
    **/
    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode == null ? null : configCode.trim();
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    public String getConfigParent() {
        return configParent;
    }

    public void setConfigParent(String configParent) {
        this.configParent = configParent == null ? null : configParent.trim();
    }

    public Integer getConfigLevel() {
        return configLevel;
    }

    public void setConfigLevel(Integer configLevel) {
        this.configLevel = configLevel;
    }

    public Integer getConfigStatus() {
        return configStatus;
    }

    public void setConfigStatus(Integer configStatus) {
        this.configStatus = configStatus;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        sb.append(", configCode=").append(configCode);
        sb.append(", configName=").append(configName);
        sb.append(", configParent=").append(configParent);
        sb.append(", configLevel=").append(configLevel);
        sb.append(", configStatus=").append(configStatus);
        sb.append(", orderBy=").append(orderBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}