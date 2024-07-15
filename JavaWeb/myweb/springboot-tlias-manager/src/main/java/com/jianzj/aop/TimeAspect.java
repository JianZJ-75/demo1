package com.jianzj.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author JianZJ
 * @Date 2024/7/12 22:53
 */

@Slf4j
@Component
//@Aspect // AOP类
public class TimeAspect {

    @Around("execution(* com.jianzj.service.*.*(..))") // 切入点表达式
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法执行耗时: {} ms", endTime - startTime);
        return result;
    }

}