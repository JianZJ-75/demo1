package com.mcbbs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:17
 */

@Component
@ConfigurationProperties(prefix = "mcbbs.alioss")
@Data
public class AliOssProperties {

    private String endpoint;
    private String bucketName;

}