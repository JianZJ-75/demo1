package com.jianzj.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/7/11 3:11
 */
public class JwtUtils {

    private static String signKey;
    private static Long expire;

    static {
        signKey = "jianzjjianzjjianzjjianzjjianzjjianzjjianzjjianzj";
        expire = 12 * 60 * 60 * 1000L;
    }

    /**
     * 生成JWT令牌
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @return
     */
    public static String generateToken(Map<String, Object> claims) {
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, signKey)
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseToken(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }

}