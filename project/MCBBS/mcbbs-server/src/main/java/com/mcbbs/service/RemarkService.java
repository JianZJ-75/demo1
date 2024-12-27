package com.mcbbs.service;

import com.mcbbs.dto.RemarkPageQueryDTO;
import com.mcbbs.entity.Remark;
import com.mcbbs.result.PageResult;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:08
 */

public interface RemarkService {

    /**
     * 发表评论
     * @param remark
     */
    void save(Remark remark);

    /**
     * 修改评论
     * @param remark
     */
    void update(Remark remark);

    /**
     * 根据id删除评论
     * @param id
     */
    void deleteById(Long id);

    /**
     * 分页查询
     * @param remarkPageQueryDTO
     * @return
     */
    PageResult page(RemarkPageQueryDTO remarkPageQueryDTO);

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    Remark getRemarkById(Long id);

    /**
     * 根据id批量删除评论
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 根据用户id获取评论
     * @param id
     * @return
     */
    List<Remark> getRemarkByUserId(Long id);
}