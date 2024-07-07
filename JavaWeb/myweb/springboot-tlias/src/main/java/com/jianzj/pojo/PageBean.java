package com.jianzj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/8 3:07
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    private Long total;     // 总记录数
    private List rows;      // 当前页数据列表

}