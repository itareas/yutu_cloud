package com.yutu.service;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysUser;

/**
* @Author: zhaobc
* @Date: 2019-12-19 19:01
* @Description: 用户服务层
**/
public interface IUserService {

    /**
    * @Author: zhaobc
    * @Date: 2019-12-19 19:02
    * @Description: 新增用户
    **/
    MsgPack insertUser(TSysUser user);

    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 19:02
     * @Description: 修改用户
     **/
    MsgPack updateUser(TSysUser user);


    /**
     * @Author: zhaobc
     * @Date: 2019-12-19 19:02
     * @Description: 删除用户
     **/
    MsgPack delteUser(String userId);
}
