package com.mcbbs.interceptor;

import com.mcbbs.constant.JwtClaimsConstant;
import com.mcbbs.context.BaseContext;
import com.mcbbs.entity.User;
import com.mcbbs.properties.JwtProperties;
import com.mcbbs.service.UserService;
import com.mcbbs.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author JianZJ
 * @Date 2024/11/26 16:59
 */

@Component
@Slf4j
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }
        //1、从请求头中获取令牌
        String token = request.getHeader(jwtProperties.getTokenName());
        //2、校验令牌
        try {
            log.info("jwt校验:{}", token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getSecretKey(), token);
            Long userId = Long.valueOf(claims.get(JwtClaimsConstant.USER_ID).toString());
            log.info("当前员工id：{}", userId);
            BaseContext.setCurrentId(userId);
            // 判断是否为管理
            User tmp = userService.test(userId);
            if (tmp.getIsAdmin()) {
                return true;
            } else {
                response.setStatus(401);
                return false;
            }
        } catch (Exception ex) {
            //4、不通过，响应401状态码
            response.setStatus(401);
            return false;
        }
    }

}