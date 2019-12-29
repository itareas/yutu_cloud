/**
* @Author: zhaobc
* @Date 2019-12-29 15:42
* @Description: 
**/
package com.yutu.mapper.mysql;

import com.yutu.entity.table.TLogOperation;

public interface TLogOperationMapper {
    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 
    **/
    int deleteByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 
    **/
    int insert(TLogOperation record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 
    **/
    int insertSelective(TLogOperation record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 
    **/
    TLogOperation selectByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 
    **/
    int updateByPrimaryKeySelective(TLogOperation record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-29 15:42
    * @Description: 
    **/
    int updateByPrimaryKey(TLogOperation record);
}