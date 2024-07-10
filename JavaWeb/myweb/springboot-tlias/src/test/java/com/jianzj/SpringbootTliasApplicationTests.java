package com.jianzj;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class SpringbootTliasApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 生成JWT
     */
    @Test
    public void testGenJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "Tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "jianzjjianzjjianzjjianzjjianzjjianzjjianzjjianzj")   // 设置签名算法, 密钥
                .setClaims(claims)                                 // 设置自定义内容(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))  // 设置有效期为一小时
                .compact();

        System.out.println(jwt);
    }

    /**
     * 解析JWT
      */
    @Test
    public void testParseJWT() {
        Claims claims = Jwts.parser()
                .setSigningKey("jianzjjianzjjianzjjianzjjianzjjianzjjianzjjianzj")
                .build()
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTcyMDY0MTA0MX0.sm-KCn9EZm9mpetDYhEZbSIuurzyKL40_OQCrLfRTxg")
                .getBody();
        System.out.println(claims);
    }

}
