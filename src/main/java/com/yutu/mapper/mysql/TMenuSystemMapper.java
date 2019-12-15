/*
*
* @Author: zhaobc
* @Date 2019-12-15 15:09
* @Description: 
*/
package com.yutu.mapper.mysql;

import com.yutu.entity.table.TMenuSystem;

import java.util.List;

public interface TMenuSystemMapper {
    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    int deleteByPrimaryKey(String uuid);

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    int insert(TMenuSystem record);

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    int insertSelective(TMenuSystem record);

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    TMenuSystem selectByPrimaryKey(String uuid);

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    int updateByPrimaryKeySelective(TMenuSystem record);

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    int updateByPrimaryKey(TMenuSystem record);

    /**
     * @Author: zhaobc
     * @Date 2019-12-15 17:03
     * @Description:根据权限id获得相应菜单
     */
    List<TMenuSystem> getRoleMenuSys(String roleId);
}