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
public class Plate implements Serializable {

    // 版块id
    private Long id;

    // 预览图
    private String preview;

    // 版块介绍图
    private String introPhoto;

    // 版块名
    private String name;

    // 版块标题
    private String title;

    // 版块内容
    private String content;

    // 用户id
    private Long userId;

    // 创建时间
    private LocalDateTime createTime;

}