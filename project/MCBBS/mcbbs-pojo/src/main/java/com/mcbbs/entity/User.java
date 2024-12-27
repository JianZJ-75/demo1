package com.mcbbs.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author JianZJ
 * @Date 2024/11/13 19:35
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    // 用户id
    private Long id;

    // 用户名
    private String username;

    // 密码
    private String password;

    // 头像
    private String photo;

    // 手机号
    private String phone;

    // 身份: 1管理员 0普通用户
    @TableField("is_admin")
    private Boolean isAdmin;

    // 注册时间
    private LocalDateTime registerTime;

}