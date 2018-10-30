package com.jk.utils;

import com.jk.model.LogInfo;
import com.jk.service.user.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


@Aspect
@Component
public class Aop {

    @Autowired
    private UserService userService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Pointcut("execution(* com.jk.service..*.*(..))")
    public  void executeService(){

    }

    //前置通知
    @Before("executeService()")
    public void before(JoinPoint joinPoint) {


         System.out.println("前置通知");

    }

    //后置通知
    @After("executeService()")
    public void after(JoinPoint joinPoint){

        System.out.println("后置通知");
        //定义一个单例化线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        /*Object[] obj =joinPoint.getArgs();//获取目标方法的参数信息

        joinPoint.getThis(); // AOP代理类信息
        joinPoint.getTarget(); // 代理的目标对象
        Signature signature=joinPoint.getSignature(); //用的最多，通知的签名
        System.out.println("代理的方法是 ： "+signature.getName()); //  打印 代理的是哪一个方法
        System.out.println("AOP代理的名字是 ： "+signature.getDeclaringTypeName());
        //  从requestAttributes中获取HttpServletRequest信息
        RequestAttributes requestAttributes= RequestContextHolder.getRequestAttributes();
        //  从requestAttributes中获取HttpServletRequest信息
        HttpServletRequest request=(HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //  获取session信息
        HttpSession session=(HttpSession)requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        System.out.println("请求 ： "+request+" ,  HttpSession : "+session);*/

        /*String params = "";
        for (int i = 0; i < obj.length; i++) {
            params +=","+obj[i];
        }
        params = params.substring(1);
        System.out.println(params);*/

        LogInfo log = new LogInfo();
        Object[] obj =joinPoint.getArgs();
        String paramVal = "";
        if(obj.length>0){
            for (int i = 0; i < obj.length; i++) {
                paramVal+=","+obj[i];
            }
            paramVal = paramVal.substring(1);
        }

        Signature signature=joinPoint.getSignature();
        String methodname = signature.getName();//方法名
        String classname = signature.getDeclaringTypeName();//类名
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String invokedate = sim.format(new Date());

        log.setMethodname(methodname);
        log.setClassname(classname);
        log.setInvokeDate(invokedate);
        log.setParamVal(paramVal);

        singleThreadExecutor.execute(new TestThread(amqpTemplate,log));





    }



}
