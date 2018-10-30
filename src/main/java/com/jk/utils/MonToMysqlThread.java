package com.jk.utils;
import com.jk.mapper.user.UserMapper;

import com.jk.model.LogInfo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class MonToMysqlThread implements Runnable{

    private MongoTemplate mongoTemplate;

    private UserMapper userMapper;


    public MonToMysqlThread(MongoTemplate mongoTemplate,UserMapper userMapper) {
        //this.userService = userService;
        this.mongoTemplate = mongoTemplate;
        this.userMapper = userMapper;

    }

    public MonToMysqlThread(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }



    @Override
    public void run() {
        send();
    }

    public MonToMysqlThread() {

    }

    public void send(){

        System.out.println("456");
        List<LogInfo> loginfoList = mongoTemplate.find(new Query(),LogInfo.class,"loginfo");
        for(int i=0;i<loginfoList.size();i++){

            System.out.println(loginfoList.get(i));
            userMapper.addMysqlFromMon(loginfoList.get(i));
        }


    }
}
