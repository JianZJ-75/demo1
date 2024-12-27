package com.mcbbs.exception;

/**
 * @Author JianZJ
 * @Date 2024/11/21 14:37
 */
public class UserBusinessException extends RuntimeException {

    public UserBusinessException(String msg) {
        super(msg);
    }

}