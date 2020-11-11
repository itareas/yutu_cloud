/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.mapper.frame;

import com.yutu.entity.table.TSysUserRole;

public interface TSysUserRoleMapper {
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
    int insert(TSysUserRole record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int insertSelective(TSysUserRole record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    TSysUserRole selectByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKeySelective(TSysUserRole record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKey(TSysUserRole record);
}