package com.jk.service.djh;

import com.alibaba.fastjson.JSONObject;
import com.jk.mapper.djh.User2Mapper;
import com.jk.model.djh.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private User2Mapper user2Mapper;

    @Override
    public JSONObject queryUser(Integer page, Integer rows, User user) {

        long count = user2Mapper.queryUserCount(user);
        int start = (page-1)*rows;
        List<User> userList = user2Mapper.queryUserList(start,rows,user);
        JSONObject json = new JSONObject();
        json.put("total",count);
        json.put("rows",userList);
        System.out.println(json);
        return json;
    }

    @Override
    public void deleteUser(Integer id) {

        System.out.println(id);
        user2Mapper.deleteUser(id);
    }

    @Override
    public int addUser(User user) {

        user.setState(1);
        return user2Mapper.addUser(user);
    }

    @Override
    public User queryUserById(Integer id) {


        return user2Mapper.queryUserById(id);
    }

    @Override
    public int updateUser(User user) {

        return user2Mapper.updateUser(user);
    }
}
