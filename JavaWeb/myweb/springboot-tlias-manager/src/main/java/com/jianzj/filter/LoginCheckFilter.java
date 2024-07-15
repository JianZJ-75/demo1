package com.jianzj.filter;

import com.alibaba.fastjson2.JSON;
import com.jianzj.pojo.Result;
import com.jianzj.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/7/12 2:45
 */

@Slf4j
//@WebFilter("/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 获取url
        String url = request.getRequestURL().toString();
        log.info("当前请求的url: {}", url);
        // 判断是否是login
        if (url.contains("login")) {
            log.info("登录请求, 放行...");
            filterChain.doFilter(request, response);
            return;
        }
        // 获取jwt令牌
        String jwt = request.getHeader("token");
        // 判断是否存在或有效
        if (!StringUtils.hasLength(jwt)) {
            log.info("jwt无效...");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSON.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }
        // 解析令牌
        try {
            JwtUtils.parseToken(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败...");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSON.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }
        // 放行
        log.info("令牌合法, 放行...");
        filterChain.doFilter(request, response);
    }

}