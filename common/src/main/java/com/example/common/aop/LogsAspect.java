package com.example.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogsAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogsAspect.class);

    @Pointcut("@annotation(com.example.common.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveLog(point, time);
        return result;
    }
    //处理日志,比如输出 保存到数据库...
    void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = signature.getName();
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        logger.info("------------------------接口日志-----------------------"+"\n"+"类名称:"+className
                +"\n"+"方法名:"+methodName+"\n"+"执行时间:"+time+"毫秒");
    }
}
