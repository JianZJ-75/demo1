package com.mcbbs.aspects;

import com.mcbbs.annotation.AutoFill;
import com.mcbbs.constant.AutoFillConstant;
import com.mcbbs.constant.DefaultVariableConstant;
import com.mcbbs.context.BaseContext;
import com.mcbbs.entity.Message;
import com.mcbbs.entity.User;
import com.mcbbs.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @Author JianZJ
 * @Date 2024/11/21 21:25
 */

@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    /**
     * 切点
     */
    @Pointcut("execution(* com.mcbbs.service.Impl.*.*(..)) && @annotation(com.mcbbs.annotation.AutoFill)")
    public void autoFillPointCut() {}

    /**
     * 前置通知, 在通知中进行公共字段的赋值
     * @param joinPoint
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info("开始进行公共字段自动填充...");
        // 获取当前被拦截方法上的数据库操作类型
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        AutoFill autoFill = methodSignature.getMethod().getAnnotation(AutoFill.class);
        OperationType value = autoFill.value();
        // 获取当前被拦截方法的参数 -- 实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];
        // 准备赋值的数据
        LocalDateTime now = LocalDateTime.now();
        Long currentId = (Long) BaseContext.getCurrentId();
        // 根据当前不同的操作类型, 为对应属性通过反射来赋值
        if (value == OperationType.LOG) {
            Method setOperateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_OPERATE_TIME, LocalDateTime.class);
            Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
            setOperateTime.invoke(entity, now);
            setCreateUser.invoke(entity, currentId);
        } else if (value == OperationType.CREATE) {
            Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
            Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
            setCreateTime.invoke(entity, now);
            setCreateUser.invoke(entity, currentId);
        } else if (value == OperationType.REGISTER) {
            Method setRegisterTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_REGISTER_TIME, LocalDateTime.class);
            Method setPhoto = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_PHOTO, String.class);
            Method setIsAdmin = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_IS_ADMIN, Boolean.class);
            setRegisterTime.invoke(entity, now);
            setPhoto.invoke(entity, DefaultVariableConstant.DefaultPhoto);
            setIsAdmin.invoke(entity, DefaultVariableConstant.DefaultIsAdmin);
        }
    }

}