package com.mcbbs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author JianZJ
 * @Date 2024/11/19 21:59
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO implements Serializable {

    // 用户名
    private String username;

    // 密码
    private String password;

}