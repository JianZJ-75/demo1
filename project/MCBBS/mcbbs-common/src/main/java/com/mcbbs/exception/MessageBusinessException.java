package com.mcbbs.exception;

/**
 * @Author JianZJ
 * @Date 2024/11/22 20:15
 */
public class MessageBusinessException extends RuntimeException {

    public MessageBusinessException(String msg) {
        super(msg);
    }

}
