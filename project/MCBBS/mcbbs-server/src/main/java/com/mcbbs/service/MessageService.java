package com.mcbbs.service;

import com.mcbbs.dto.MessagePageQueryDTO;
import com.mcbbs.entity.Message;
import com.mcbbs.result.PageResult;
import com.mcbbs.vo.MessageAndPlateVO;
import com.mcbbs.vo.MessageAndRemarkVO;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:07
 */

public interface MessageService {

    /**
     * 分页查询
     * @param messagePageQueryDTO
     * @return
     */
    PageResult page(MessagePageQueryDTO messagePageQueryDTO);

    /**
     * 新增帖子
     * @param message
     */
    void save(Message message);

    /**
     * 根据id获取帖子
     * @param id
     * @return
     */
    MessageAndRemarkVO getMessageAndRemarkById(Long id);

    /**
     * 修改帖子
     * @param message
     */
    void update(Message message);

    /**
     * 根据id删除帖子
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据id查询帖子
     * @param id
     * @return
     */
    Message getMessageById(Long id);

    /**
     * 根据id批量删除帖子
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * getMessagesByUserId
     * @param id
     * @return
     */
    List<MessageAndPlateVO> getMessagesByUserId(Long id);
}
