package com.mcbbs.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> implements Serializable {

    // 总记录数
    private Long total;

    // 总页数
    private Long totalPage;

    // 当前分页数据集合
    private List<T> records;

}