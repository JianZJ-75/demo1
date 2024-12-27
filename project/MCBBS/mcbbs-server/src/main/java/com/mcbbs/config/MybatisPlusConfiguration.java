package com.mcbbs.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author JianZJ
 * @Date 2024/11/26 1:08
 */

@Configuration
@Slf4j
public class MybatisPlusConfiguration {

    @Bean
    public PaginationInnerInterceptor paginationInterceptor() {
        log.info("正在配置mybatis-plus...");
        return new PaginationInnerInterceptor();
    }

}