package com.mcbbs.handler;

import com.mcbbs.constant.MessageConstant;
import com.mcbbs.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:16
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param e
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(Exception e) {
        log.error("异常信息：{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    /**
     * 处理SQL异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String message = ex.getMessage();
        if (message.contains("Duplicate entry")) {
            // 如果存在唯一约束重复插入
            String username = message.split(" ")[2];
            return Result.error(username + MessageConstant.ALREADY_EXISTS);
        } else {
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }
    }

}