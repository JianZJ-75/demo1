package com.jianzj.controller;

import com.jianzj.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author JianZJ
 * @Date 2024/7/11 1:51
 */

@Slf4j
@RestController
public class CookieController {

    // 设置Cookie
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        // 设置Cookie/响应Cookie
        response.addCookie(new Cookie("login_username", "jianzj"));
        return Result.success();
    }

    // 获取Cookie
    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request) {
        // 获取所有的Cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            // 输出name为login_name的cookie
            if (cookie.getName().equals("login_username")) {
                System.out.println("login_username:" + cookie.getValue());
            }
        }
        return Result.success();
    }

}