/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.mapper.frame;

import com.yutu.entity.table.TSysRoleMenusys;

public interface TSysRoleMenusysMapper {
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
    int insert(TSysRoleMenusys record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int insertSelective(TSysRoleMenusys record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    TSysRoleMenusys selectByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKeySelective(TSysRoleMenusys record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKey(TSysRoleMenusys record);
}