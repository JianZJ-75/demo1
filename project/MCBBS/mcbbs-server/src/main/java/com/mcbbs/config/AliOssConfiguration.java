package com.mcbbs.config;

import com.mcbbs.properties.AliOssProperties;
import com.mcbbs.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:23
 */

@Configuration
@Slf4j
public class AliOssConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties) {
        log.info("开始上传阿里云文件上传工具类对象: {}", aliOssProperties);
        return new AliOssUtil(aliOssProperties.getEndpoint(), aliOssProperties.getBucketName());
    }

}