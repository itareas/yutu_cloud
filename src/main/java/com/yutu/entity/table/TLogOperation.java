/**
* @Author: zhaobc
* @Date 2019-12-29 15:42
* @Description: 
**/
package com.yutu.entity.table;

import java.io.Serializable;
import java.util.Date;

public class TLogOperation implements Serializable {
    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 编码
    **/
    private String uuid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 操作数据库
    **/
    private String operateDb;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 操作表
    **/
    private String operateDt;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 操作类型   增删改
    **/
    private String operateType;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 主键
    **/
    private String operatePrimarykey;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 操作内容
    **/
    private String operateContent;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 操作人
    **/
    private String operatePerson;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 操作时间
    **/
    private Date operateDatetime;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 日志类型
    **/
    private String logType;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: appkey
    **/
    private String appkey;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: token
    **/
    private String token;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 备注
    **/
    private String remarks;

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: t_log_operation
    **/
    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getOperateDb() {
        return operateDb;
    }

    public void setOperateDb(String operateDb) {
        this.operateDb = operateDb == null ? null : operateDb.trim();
    }

    public String getOperateDt() {
        return operateDt;
    }

    public void setOperateDt(String operateDt) {
        this.operateDt = operateDt == null ? null : operateDt.trim();
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    public String getOperatePrimarykey() {
        return operatePrimarykey;
    }

    public void setOperatePrimarykey(String operatePrimarykey) {
        this.operatePrimarykey = operatePrimarykey == null ? null : operatePrimarykey.trim();
    }

    public String getOperateContent() {
        return operateContent;
    }

    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent == null ? null : operateContent.trim();
    }

    public String getOperatePerson() {
        return operatePerson;
    }

    public void setOperatePerson(String operatePerson) {
        this.operatePerson = operatePerson == null ? null : operatePerson.trim();
    }

    public Date getOperateDatetime() {
        return operateDatetime;
    }

    public void setOperateDatetime(Date operateDatetime) {
        this.operateDatetime = operateDatetime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey == null ? null : appkey.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 
    **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", operateDb=").append(operateDb);
        sb.append(", operateDt=").append(operateDt);
        sb.append(", operateType=").append(operateType);
        sb.append(", operatePrimarykey=").append(operatePrimarykey);
        sb.append(", operateContent=").append(operateContent);
        sb.append(", operatePerson=").append(operatePerson);
        sb.append(", operateDatetime=").append(operateDatetime);
        sb.append(", logType=").append(logType);
        sb.append(", appkey=").append(appkey);
        sb.append(", token=").append(token);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}