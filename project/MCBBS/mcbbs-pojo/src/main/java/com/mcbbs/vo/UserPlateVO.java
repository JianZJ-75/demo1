package com.mcbbs.vo;

import com.mcbbs.entity.Message;
import com.mcbbs.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author JianZJ
 * @Date 2024/11/19 20:11
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPlateVO implements Serializable {

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

    // 用户
    private User user;

    // 最新帖子id
    private Long messageId;

    // 最新帖子
    private Message message;

    // 总帖子数
    private Long total;

    // 总查看数
    private Long totalViewTimes;

}