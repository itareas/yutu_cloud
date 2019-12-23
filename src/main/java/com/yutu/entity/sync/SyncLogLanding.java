package com.yutu.entity.sync;

import com.yutu.entity.table.TLogLanding;

/**
 * @Author: zhaobc
 * @Date: 2019-12-23 9:22
 * @Description:登录日志接口
 */
public class SyncLogLanding extends TLogLanding {
    /**
     * @Author: zhaobc
     * @Date: 2019-12-23 9:29
     * @Description: 子系统标识码
     **/
    private  String  APPKEY;
    /**
     * @Author: zhaobc
     * @Date: 2019-12-23 9:30
     * @Description: 临时令牌
     **/
    private  String  TOKEN;

    public String getAPPKEY() {
        return APPKEY;
    }

    public String getTOKEN() {
        return TOKEN;
    }
}
