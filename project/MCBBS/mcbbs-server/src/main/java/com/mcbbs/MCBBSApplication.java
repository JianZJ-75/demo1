package com.mcbbs;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author JianZJ
 * @Date 2024/11/13 16:30
 */

@MapperScan("com.mcbbs.mapper")
@SpringBootApplication
@Slf4j
public class MCBBSApplication {
    public static void main(String[] args) {
        SpringApplication.run(MCBBSApplication.class, args);
        log.info("server started");
    }
}