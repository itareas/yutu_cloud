/**
* @Author: zhaobc
* @Date 2019-12-16 22:26
* @Description: 
**/
package com.yutu.entity.sync;

import com.yutu.entity.table.TSysUser;

import java.io.Serializable;

/**
* @Author: zhaobc
* @Date: 2019-12-19 14:31
* @Description: 接口使用的用户实体类
**/
public class SyncUser extends TSysUser  implements Serializable {

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}