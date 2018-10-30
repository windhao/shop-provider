package com.jk.utils;

import com.alibaba.fastjson.JSON;
import com.jk.model.LogInfo;

import org.springframework.amqp.core.AmqpTemplate;

/*千万不要再线程类里面注入任何东西，如果你注入了，或者写了@autowrite,那么你就是个傻子*/
public class TestThread implements Runnable{



    private AmqpTemplate amqpTemplate;

    //private UserService userService;

    private LogInfo log;

    public TestThread(AmqpTemplate amqpTemplate,LogInfo log) {
         //this.userService = userService;
         this.amqpTemplate = amqpTemplate;
         this.log = log;

    }

    public TestThread(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }



    @Override
    public void run() {
       send();
    }

    public TestThread() {

    }

    public void send(){
        //userService.sendAmq(log);
        amqpTemplate.convertAndSend("aop", JSON.toJSONString(log));

    }
}
