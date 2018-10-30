package com.jk.service.user;

import com.jk.mapper.user.UserMapper;
import com.jk.model.LogInfo;
import com.jk.utils.MonToMysqlThread;
import com.jk.utils.TestThread;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void test(Integer a,Integer b) {

        System.out.println("测试");
    }

    @Override
    public void test2() {
        System.out.println("测试2");
    }

    @Override
    public void monToMysql() {

        System.out.println("123");

        //定义一个定长可周期性执行线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(6);

        //ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();


        scheduledThreadPool.execute(new MonToMysqlThread(mongoTemplate,userMapper));
        //singleThreadExecutor.execute(new MonToMysqlThread(mongoTemplate,userMapper));

    }

    @Override
    public List<HashMap<String, Object>> queryChart() {

        List<HashMap<String, Object>> logInfos = userMapper.queryChart();
        return logInfos;
    }


}
