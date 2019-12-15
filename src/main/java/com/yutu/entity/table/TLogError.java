/*
*
* @Author: zhaobc
* @Date 2019-12-15 15:09
* @Description: 
*/
package com.yutu.entity.table;

import java.io.Serializable;

public class TLogError implements Serializable {
    /**
     * 主键
     */
    private String uuid;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 等级
     */
    private String logLevel;

    /**
     * 类别
     */
    private String logCategory;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 线程名称
     */
    private String threadName;

    /**
     * 线程日志
     */
    private String logLine;

    /**
     * 所有类型
     */
    private String allCategory;

    /**
     * 详细信息
     */
    private String logMessage;

    /**
     * 备注
     */
    private String remarks;

    /**
     * t_log_error
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
    public String getProjectName() {
        return projectName;
    }

    /**
     * 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * 等级
     */
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel == null ? null : logLevel.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLogCategory() {
        return logCategory;
    }

    /**
     * 类别
     */
    public void setLogCategory(String logCategory) {
        this.logCategory = logCategory == null ? null : logCategory.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getThreadName() {
        return threadName;
    }

    /**
     * 线程名称
     */
    public void setThreadName(String threadName) {
        this.threadName = threadName == null ? null : threadName.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLogLine() {
        return logLine;
    }

    /**
     * 线程日志
     */
    public void setLogLine(String logLine) {
        this.logLine = logLine == null ? null : logLine.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getAllCategory() {
        return allCategory;
    }

    /**
     * 所有类型
     */
    public void setAllCategory(String allCategory) {
        this.allCategory = allCategory == null ? null : allCategory.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getLogMessage() {
        return logMessage;
    }

    /**
     * 详细信息
     */
    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage == null ? null : logMessage.trim();
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