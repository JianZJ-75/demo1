package com.mcbbs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author JianZJ
 * @Date 2024/11/23 17:04
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemarkPageQueryDTO implements Serializable {

    // 页码
    private Integer page;

    // 每页记录数
    private Integer pageSize;

    // 关键词(模糊)
    private String keyWord;

}
