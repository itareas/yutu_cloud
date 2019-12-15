package com.yutu.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * @Author: zhaobc
 * @Date: 2019/12/15 21:02
 * @Description:
 */
public class JsonListUtil {
   /**
   * @Author: zhaobc
   * @Date: 2019/12/15 21:03
   * @Description: List<T> 转 json 保存到数据库
   **/
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
    * @Author: zhaobc
    * @Date: 2019/12/15 21:03
    * @Description: json 转 List<T>
    **/
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }
}
