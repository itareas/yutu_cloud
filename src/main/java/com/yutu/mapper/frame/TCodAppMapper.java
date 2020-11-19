/**
* @Author: zhaobc
* @Date 2020-07-28 17:32
* @Description: 
**/
package com.yutu.mapper.frame;

import com.yutu.entity.table.TCodApp;
import org.apache.ibatis.annotations.Param;

public interface TCodAppMapper {
    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    int deleteByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    int insert(TCodApp record);

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    int insertSelective(TCodApp record);

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    TCodApp selectByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    int updateByPrimaryKeySelective(TCodApp record);

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    int updateByPrimaryKey(TCodApp record);

    /**
     * @Author: zhaobc
     * @Date: 2020/7/28 17:34
     * @Description: 获得
     **/
    int getAppCount(@Param("appKey") String appKey);
}