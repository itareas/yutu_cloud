package com.yutu.entity.api;

/**
 * @Author: zhaobc
 * @Date: 2019-12-23 9:28
 * @Description:验证类
 */
public class ApiAuth {
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

    public void setAPPKEY(String APPKEY) {
        this.APPKEY = APPKEY;
    }

    public String getTOKEN() {
        return TOKEN;
    }

    public void setTOKEN(String TOKEN) {
        this.TOKEN = TOKEN;
    }
}
