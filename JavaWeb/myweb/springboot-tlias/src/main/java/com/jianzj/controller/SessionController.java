package com.jianzj.controller;

import com.jianzj.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author JianZJ
 * @Date 2024/7/11 2:05
 */

@Slf4j
@RestController
public class SessionController {

    // 往HttpSession中存储值
    @GetMapping("/s1")
    public Result session1(HttpSession session) {
        log.info("HttpSession-s1: {}", session.hashCode());
        // 往Session中存储数据
        session.setAttribute("loginUser", "jianzj");
        return Result.success();
    }

    // 从HttpSession中获取值
    @GetMapping("/s2")
    public Result session2(HttpServletRequest request) {
        HttpSession session = request.getSession();
        log.info("HttpSession-s2: {}", session.hashCode());
        // 从Session中获取数据
        Object loginUser = session.getAttribute("loginUser");
        log.info("loginUser: {}", loginUser);
        return Result.success(loginUser);
    }

}