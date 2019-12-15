/*
*
* @Author: zhaobc
* @Date 2019-12-15 15:09
* @Description: 
*/
package com.yutu.entity.table;

import java.io.Serializable;

public class TMenuSystem implements Serializable {
    /**
     * 编码
     */
    private String uuid;

    /**
     * 菜单名称
     */
    private String menuTitle;

    /**
     * 菜单类型：1.外部sso弹出  2.内部跳转
     */
    private Integer menuType;

    /**
     * 菜单url地址
     */
    private String menuUrl;

    /**
     * 页面中的class，为了调整配置样式
     */
    private String menuPageClass;

    /**
     * 页面中其他的属性值
     */
    private String menuPageOther;

    /**
     * 排序
     */
    private Integer orderBy;

    /**
     * 用户逻辑删除  0 ：正常   1：删除
     */
    private Integer deleteStatus;

    /**
     * 备注
     */
    private String remarks;

    /**
     * t_menu_system
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
    public String getMenuTitle() {
        return menuTitle;
    }

    /**
     * 菜单名称
     */
    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle == null ? null : menuTitle.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Integer getMenuType() {
        return menuType;
    }

    /**
     * 菜单类型：1.外部sso弹出  2.内部跳转
     */
    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getMenuUrl() {
        return menuUrl;
    }

    /**
     * 菜单url地址
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getMenuPageClass() {
        return menuPageClass;
    }

    /**
     * 页面中的class，为了调整配置样式
     */
    public void setMenuPageClass(String menuPageClass) {
        this.menuPageClass = menuPageClass == null ? null : menuPageClass.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public String getMenuPageOther() {
        return menuPageOther;
    }

    /**
     * 页面中其他的属性值
     */
    public void setMenuPageOther(String menuPageOther) {
        this.menuPageOther = menuPageOther == null ? null : menuPageOther.trim();
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Integer getOrderBy() {
        return orderBy;
    }

    /**
     * 排序
     */
    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    /**
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 用户逻辑删除  0 ：正常   1：删除
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
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