package com.jianzj.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author JianZJ
 * @Date 2024/7/13 2:02
 */

@Slf4j
@Component
//@Aspect
public class MyAspect1 {

    @Pointcut("execution(* com.jianzj.service.EmpService.get(..)) || " +
            "execution(* com.jianzj.service.EmpService.add(..))")
    public void pt() {}

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }

}