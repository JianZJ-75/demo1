package com.mcbbs.service;

import com.mcbbs.dto.LogPageQueryDTO;
import com.mcbbs.entity.Log;
import com.mcbbs.result.PageResult;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:02
 */

public interface LogService {

    /**
     * 添加日志
     * @param build
     */
    void add(Log build);

    /**
     * 分页查询
     * @param logPageQueryDTO
     * @return
     */
    PageResult page(LogPageQueryDTO logPageQueryDTO);

    /**
     * 根据id查询日志
     * @param id
     * @return
     */
    Log getLogById(Long id);

    /**
     * 根据id批量删除日志
     * @param ids
     */
    void deleteByIds(List<Long> ids);
}
