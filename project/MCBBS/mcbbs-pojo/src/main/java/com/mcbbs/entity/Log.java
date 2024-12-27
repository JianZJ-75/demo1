package com.mcbbs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author JianZJ
 * @Date 2024/11/13 19:36
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable {

    // 日志id
    private Long id;

    // 类名
    private String className;

    // 方法名
    private String methodName;

    // 参数
    private String argsName;

    // 用户id
    private Long userId;

    // 操作时间
    private LocalDateTime operateTime;

}