package com.mcbbs.vo;

import com.mcbbs.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author JianZJ
 * @Date 2024/11/22 19:49
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemarkVO implements Serializable {

    // 评论id
    private Long id;

    // 评论内容
    private String content;

    // 发布时间
    private LocalDateTime createTime;

    // 帖子id
    private Long messageId;

    // 用户id
    private Long userId;

    // 用户
    private User user;

}
