/*
*
* @Author: zhaobc
* @Date 2019-12-15 15:09
* @Description: 
*/
package com.yutu.entity.table;

import java.io.Serializable;
import java.util.Date;

public class TLogOperation implements Serializable {
    /**
     * 编码
     */
    private String uuid;

    /**
     * 操作数据库
     */
    private String operateDb;

    /**
     * 操作表
     */
    private String operateDt;

    /**
     * 操作类型   增删改
     */
    private String operateType;

    /**
     * 主键
     */
    private String operatePrimarykey;

    /**
     * 操作内容
     */
    private String operateContent;

    /**
     * 操作人
     */
    private String operatePerson;

    /**
     * 操作时间
     */
    private Date operateDatetime;

    /**
     * 日志类型
     */
    private String logType;

    /**
     * 备注
     */
    private String remarks;

    /**
     * t_log_operation
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
    public String getOperateDb() {
        return operateDb;
    }

    /**
     * 操作数据库
     */
    public void setOperateDb(String operateDb) {
        this.operateDb = operateDb == null ? null : operateDb.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOperateDt() {
        return operateDt;
    }

    /**
     * 操作表
     */
    public void setOperateDt(String operateDt) {
        this.operateDt = operateDt == null ? null : operateDt.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOperateType() {
        return operateType;
    }

    /**
     * 操作类型   增删改
     */
    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOperatePrimarykey() {
        return operatePrimarykey;
    }

    /**
     * 主键
     */
    public void setOperatePrimarykey(String operatePrimarykey) {
        this.operatePrimarykey = operatePrimarykey == null ? null : operatePrimarykey.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOperateContent() {
        return operateContent;
    }

    /**
     * 操作内容
     */
    public void setOperateContent(String operateContent) {
        this.operateContent = operateContent == null ? null : operateContent.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getOperatePerson() {
        return operatePerson;
    }

    /**
     * 操作人
     */
    public void setOperatePerson(String operatePerson) {
        this.operatePerson = operatePerson == null ? null : operatePerson.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Date getOperateDatetime() {
        return operateDatetime;
    }

    /**
     * 操作时间
     */
    public void setOperateDatetime(Date operateDatetime) {
        this.operateDatetime = operateDatetime;
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 日志类型
     */
    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
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
        sb.append(", operateDb=").append(operateDb);
        sb.append(", operateDt=").append(operateDt);
        sb.append(", operateType=").append(operateType);
        sb.append(", operatePrimarykey=").append(operatePrimarykey);
        sb.append(", operateContent=").append(operateContent);
        sb.append(", operatePerson=").append(operatePerson);
        sb.append(", operateDatetime=").append(operateDatetime);
        sb.append(", logType=").append(logType);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}