package com.mcbbs.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/22 19:41
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageAndRemarkVO implements Serializable {

    // 帖子id
    private Long id;

    // 帖子标题
    private String title;

    // 帖子内容
    private String content;

    // 用户id
    private Long userId;

    // 版块id
    private Long plateId;

    // 查看次数
    private Long viewTimes;

    // 发表时间
    private LocalDateTime createTime;

    // 评论
    private List<RemarkVO> remarkList;

}
