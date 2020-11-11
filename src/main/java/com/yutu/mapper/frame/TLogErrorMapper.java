/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.mapper.frame;

import com.yutu.entity.table.TLogError;

public interface TLogErrorMapper {
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
    int insert(TLogError record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int insertSelective(TLogError record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    TLogError selectByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKeySelective(TLogError record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKey(TLogError record);
}