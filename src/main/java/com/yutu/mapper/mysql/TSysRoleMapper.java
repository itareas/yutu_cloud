/*
*
* @Author: zhaobc
* @Date 2019-12-15 15:09
* @Description: 
*/
package com.yutu.mapper.mysql;

import com.yutu.entity.table.TSysRole;

public interface TSysRoleMapper {
    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    int insert(TSysRole record);

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    int insertSelective(TSysRole record);
}