package com.yutu.mapper.postgresql;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:IMySqlMapper
 * @Author:zhaobc
 * @Date:2019/4/17 10:48
 * @Description:
 **/
public interface IPostgreSqlMapper {
    List<Map<String, Object>> getMySqlTest(@Param("userName") String userName);
}
