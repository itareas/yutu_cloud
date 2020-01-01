/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.mapper.mysql;

import com.yutu.entity.table.TSysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TSysUserMapper {
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
    int insert(TSysUser record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int insertSelective(TSysUser record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    TSysUser selectByPrimaryKey(String uuid);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKeySelective(TSysUser record);

    /**
    * @Author: zhaobc
    * @Date 2019-12-16 22:26
    * @Description: 
    **/
    int updateByPrimaryKey(TSysUser record);

    /**
     * @Author: zhaobc
     * @Date: 2019/12/15 17:41
     * @Description: 用户登录
     **/
    Map<String,String> getLoginVerification(@Param("userName") String userName, @Param("userPwd") String userPwd);

    /**
    * @Author: zhaobc
    * @Date: 2020/1/1 12:47
    * @Description: 获得所有用户
    **/
    List<TSysUser> getUserAll();
}