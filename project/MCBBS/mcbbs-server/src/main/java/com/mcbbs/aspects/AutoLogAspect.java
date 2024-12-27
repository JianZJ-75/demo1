package com.mcbbs.aspects;

import com.mcbbs.annotation.AutoFill;
import com.mcbbs.entity.Log;
import com.mcbbs.enumeration.OperationType;
import com.mcbbs.service.LogService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/11/22 20:39
 */

@Aspect
@Component
@Slf4j
public class AutoLogAspect {

    @Autowired
    private LogService logService;

    /**
     * 切点
     */
    @Pointcut("execution(* com.mcbbs.service.Impl.*.*(..))")
    public void autoLogPointCut() {}

    @Pointcut("execution(* com.mcbbs.service.Impl.LogServiceImpl.*(..))")
    public void pc1() {}

    @Pointcut("execution(* com.mcbbs.service.Impl.UserServiceImpl.login(..))" +
            "&& execution(* com.mcbbs.service.Impl.UserServiceImpl.register(..))")
    public void pc2() {}

    @AfterReturning("autoLogPointCut() && !pc1() && !pc2()")
    public void autoLog(JoinPoint joinPoint) {
        log.info("开始记录日志...");
        // 获取方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = methodSignature.getMethod().getName();
        String argsName = Arrays.toString(joinPoint.getArgs());
        logService.add(
                Log.builder()
                        .className(className)
                        .methodName(methodName)
                        .argsName(argsName)
                        .build()
        );
    }

}
