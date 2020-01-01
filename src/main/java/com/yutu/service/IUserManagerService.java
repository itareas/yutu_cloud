package com.yutu.service;

import com.yutu.entity.MsgPack;
import com.yutu.entity.table.TSysUser;

/**
* @Author: zhaobc
* @Date: 2019-12-19 19:01
* @Description: 用户服务层
**/
public interface IUserManagerService {

    /**
    * @Author: zhaobc
    * @Date: 2019-12-19 19:02
    * @Description: 获得所有用户
    **/
    MsgPack getUserAll();



}
