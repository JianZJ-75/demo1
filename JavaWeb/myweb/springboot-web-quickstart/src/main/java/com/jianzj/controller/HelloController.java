package com.jianzj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author JianZJ
 * @Date 2024/7/2 17:57
 */

// 请求处理类
@RestController
public class HelloController {
    @RequestMapping("/index")
    public String index() {
        System.out.println("hello SpringBoot~");
        return "Hello SpringBoot~";
    }
}