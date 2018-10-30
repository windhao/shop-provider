package com.jk.mapper.user;

import com.jk.model.LogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;


public interface UserMapper {

    @Insert("insert into t_log(methodname,classname,invokeDate,paramVal) values(#{methodname},#{classname},#{invokeDate},#{paramVal}) ")
    void addMysqlFromMon(LogInfo loginfo);

    @Select("select  COUNT(*) as y,methodname as name FROM t_log  GROUP BY methodname")
    List<HashMap<String, Object>> queryChart();
}
