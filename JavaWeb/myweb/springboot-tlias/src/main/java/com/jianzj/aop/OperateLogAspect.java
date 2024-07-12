package com.jianzj.aop;

import com.alibaba.fastjson2.JSON;
import com.jianzj.pojo.OperateLog;
import com.jianzj.service.OperateLogService;
import com.jianzj.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/7/13 2:52
 */

@Slf4j
@Component
@Aspect
public class OperateLogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogService operateLogService;

    @Pointcut("@annotation(com.jianzj.annotation.Log)")
    public void pt() {}

    @Around("pt()")
    public Object OperateLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 操作人ID
        String jwt = request.getHeader("token");
        Integer operateUser = (Integer) JwtUtils.parseToken(jwt).get("id");
        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        // 操作类名
        String className = joinPoint.getTarget().getClass().getName();
        // 操作方法名
        String methodName = joinPoint.getSignature().getName();
        // 操作方法参数
        String methodParam = Arrays.toString(joinPoint.getArgs());
        // 调用原始方法
        Long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        // 操作方法返回值
        String returnValue = JSON.toJSONString(result);
        // 操作耗时
        Long end = System.currentTimeMillis();
        Long costTime = end - begin;
        // 添加日志
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParam, returnValue, costTime);
        operateLogService.insert(operateLog);
        log.info("AOP操作日志: {}", operateLog);
        return result;
    }

}