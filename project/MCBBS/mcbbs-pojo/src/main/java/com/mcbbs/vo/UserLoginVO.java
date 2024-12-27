package com.mcbbs.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author JianZJ
 * @Date 2024/11/19 22:01
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO implements Serializable {

    // 用户id
    private Long id;

    // 用户名
    private String username;

    // jwt令牌
    private String token;

}