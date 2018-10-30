package com.jk.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.model.LogInfo;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "aop")
public class GetRabbitMqData {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RabbitHandler
    public void getMsg(String msg){
        //System.out.println(msg);

      /*  JSONObject jb = JSONArray.parseObject(msg);
        Integer id = jb.getInteger("id");*/

        System.out.println(msg);
        JSONObject jsonObject = JSONArray.parseObject(msg);
        mongoTemplate.save(jsonObject,"loginfo");
    }


}
