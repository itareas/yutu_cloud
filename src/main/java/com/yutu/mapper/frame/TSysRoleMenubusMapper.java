/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.mapper.frame;

import com.yutu.entity.table.TSysRoleMenubus;

public interface TSysRoleMenubusMapper {
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
    int insert(TSysRoleMenubus record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int insertSelective(TSysRoleMenubus record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    TSysRoleMenubus selectByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKeySelective(TSysRoleMenubus record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKey(TSysRoleMenubus record);
}