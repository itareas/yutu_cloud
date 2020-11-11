/**
* @Author: zhaobc
* @Date 2020-07-28 17:32
* @Description: 
**/
package com.yutu.entity.table;

import java.io.Serializable;
import java.util.Date;

public class TBasApp implements Serializable {
    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 编码
    **/
    private String uuid;

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 应用标识
    **/
    private String appKey;

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 应用名称
    **/
    private String appName;

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 应用类型：0：项目； 1:产品
    **/
    private Integer appType;

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 是否启动：0：不启动； 1：启动
    **/
    private Integer enable;

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 更新时间
    **/
    private Date updateTime;

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 备注
    **/
    private String remarks;

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: t_cod_app
    **/
    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
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
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", appKey=").append(appKey);
        sb.append(", appName=").append(appName);
        sb.append(", appType=").append(appType);
        sb.append(", enable=").append(enable);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}