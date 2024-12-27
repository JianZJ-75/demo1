package com.mcbbs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author JianZJ
 * @Date 2024/11/21 20:07
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessagePageQueryDTO implements Serializable {

    // 页码
    private Integer page;

    // 每页记录数
    private Integer pageSize;

    // 版块id
    private Long plateId;

    // 关键词(模糊)
    private String keyWord;

    // 排序方法, 默认(0), 热度(1)
    // 时间: 全部(=默认(0)) 一周(2) 一个月(3) 一年(4)
    private Integer operation;

}