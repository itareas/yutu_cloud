/*
*
* @Author: zhaobc
* @Date 2019-12-15 15:09
* @Description: 
*/
package com.yutu.mapper.mysql;

import com.yutu.entity.table.TLogLanding;

public interface TLogLandingMapper {
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
    int insert(TLogLanding record);

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    int insertSelective(TLogLanding record);

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    TLogLanding selectByPrimaryKey(String uuid);

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    int updateByPrimaryKeySelective(TLogLanding record);

    /**
     *
    * @Author: zhaobc
    * @Date 2019-12-15 15:09
    * @Description: 
     */
    int updateByPrimaryKey(TLogLanding record);
}