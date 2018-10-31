package com.jk.service.djh;

import com.alibaba.fastjson.JSONObject;
import com.jk.model.djh.User;

public interface UserService {

    JSONObject queryUser(Integer page, Integer rows, User user);

    void deleteUser(Integer id);

    int addUser(User user);

    User queryUserById(Integer id);

    int updateUser(User user);
}
