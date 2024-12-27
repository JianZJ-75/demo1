package com.mcbbs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:27
 */

@Component
@ConfigurationProperties(prefix = "mcbbs.jwt")
@Data
public class JwtProperties {

    private String secretKey;
    private long ttl;
    private String tokenName;

}