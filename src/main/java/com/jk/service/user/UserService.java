package com.jk.service.user;


import com.jk.model.LogInfo;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    void test(Integer a,Integer b);

    void test2();

    void monToMysql();

    List<HashMap<String, Object>> queryChart();

}
