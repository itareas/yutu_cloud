package com.yutu.entity;

/**
 * @Author: zhaobc
 * @Date: 2020/11/11 14:28
 * @Description: 返回状态枚举类
 **/
public enum MsgStatus {
    SUCCESS(1, "运行成功!"),
    FAIL(0, "运行失败!");


    /**
     * @Author: zhaobc
     * @Date: 2020/11/11 14:30
     * @Description: 状态码
     **/
    private int code;

    /**
     * @Author: zhaobc
     * @Date: 2020/11/11 14:31
     * @Description: 错误描述
     **/
    private String msg;


    MsgStatus(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    //获得code
    public int getCode() {
        return code;
    }
    //获得描述
    public String getMsg() {
        return msg;
    }
}
