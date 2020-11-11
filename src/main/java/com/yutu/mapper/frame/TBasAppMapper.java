/**
* @Author: zhaobc
* @Date 2020-07-28 17:32
* @Description: 
**/
package com.yutu.mapper.frame;

import com.yutu.entity.table.TBasApp;
import org.apache.ibatis.annotations.Param;

public interface TBasAppMapper {
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
    int insert(TBasApp record);

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    int insertSelective(TBasApp record);

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    TBasApp selectByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    int updateByPrimaryKeySelective(TBasApp record);

    /**
    * @Author: zhaobc
    * @Date 2020-07-28 17:32
    * @Description: 
    **/
    int updateByPrimaryKey(TBasApp record);

    /**
     * @Author: zhaobc
     * @Date: 2020/7/28 17:34
     * @Description: 获得
     **/
    int getAppCount(@Param("appKey") String appKey);
}