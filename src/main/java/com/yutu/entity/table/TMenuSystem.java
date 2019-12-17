/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.entity.table;

import java.io.Serializable;

public class TMenuSystem implements Serializable {
    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 编码
    **/
    private String uuid;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 菜单名称
    **/
    private String menuTitle;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 菜单类型：1.外部sso弹出  2.内部跳转
    **/
    private Integer menuType;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 菜单url地址
    **/
    private String menuUrl;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 页面中的class，为了调整配置样式
    **/
    private String menuPageClass;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 页面中其他的属性值
    **/
    private String menuPageOther;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 排序
    **/
    private Integer orderBy;

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 用户逻辑删除  0 ：正常   1：删除
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
    * @Description: t_menu_system
    **/
    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle == null ? null : menuTitle.trim();
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuPageClass() {
        return menuPageClass;
    }

    public void setMenuPageClass(String menuPageClass) {
        this.menuPageClass = menuPageClass == null ? null : menuPageClass.trim();
    }

    public String getMenuPageOther() {
        return menuPageOther;
    }

    public void setMenuPageOther(String menuPageOther) {
        this.menuPageOther = menuPageOther == null ? null : menuPageOther.trim();
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
        sb.append(", menuTitle=").append(menuTitle);
        sb.append(", menuType=").append(menuType);
        sb.append(", menuUrl=").append(menuUrl);
        sb.append(", menuPageClass=").append(menuPageClass);
        sb.append(", menuPageOther=").append(menuPageOther);
        sb.append(", orderBy=").append(orderBy);
        sb.append(", deleteStatus=").append(deleteStatus);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}