/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.mapper.frame;

import com.yutu.entity.table.TSysUserOrganization;

public interface TSysUserOrganizationMapper {
    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int deleteByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int insert(TSysUserOrganization record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int insertSelective(TSysUserOrganization record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    TSysUserOrganization selectByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKeySelective(TSysUserOrganization record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKey(TSysUserOrganization record);
}