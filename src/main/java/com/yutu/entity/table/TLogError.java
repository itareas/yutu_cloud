/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.entity.table;

import java.io.Serializable;

public class TLogError implements Serializable {
    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 主键
    **/
    private String uuid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 项目名称
    **/
    private String projectName;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 创建时间
    **/
    private String createDate;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 等级
    **/
    private String logLevel;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 类别
    **/
    private String logCategory;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 文件名
    **/
    private String fileName;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 线程名称
    **/
    private String threadName;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 线程日志
    **/
    private String logLine;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 所有类型
    **/
    private String allCategory;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 详细信息
    **/
    private String logMessage;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 备注
    **/
    private String remarks;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: t_log_error
    **/
    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel == null ? null : logLevel.trim();
    }

    public String getLogCategory() {
        return logCategory;
    }

    public void setLogCategory(String logCategory) {
        this.logCategory = logCategory == null ? null : logCategory.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName == null ? null : threadName.trim();
    }

    public String getLogLine() {
        return logLine;
    }

    public void setLogLine(String logLine) {
        this.logLine = logLine == null ? null : logLine.trim();
    }

    public String getAllCategory() {
        return allCategory;
    }

    public void setAllCategory(String allCategory) {
        this.allCategory = allCategory == null ? null : allCategory.trim();
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage == null ? null : logMessage.trim();
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
        sb.append(", projectName=").append(projectName);
        sb.append(", createDate=").append(createDate);
        sb.append(", logLevel=").append(logLevel);
        sb.append(", logCategory=").append(logCategory);
        sb.append(", fileName=").append(fileName);
        sb.append(", threadName=").append(threadName);
        sb.append(", logLine=").append(logLine);
        sb.append(", allCategory=").append(allCategory);
        sb.append(", logMessage=").append(logMessage);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}