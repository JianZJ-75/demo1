package com.mcbbs.controller.admin;

import com.mcbbs.dto.MessagePageQueryDTO;
import com.mcbbs.entity.Message;
import com.mcbbs.result.PageResult;
import com.mcbbs.result.Result;
import com.mcbbs.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:26
 */

@RestController("adminMessageController")
@Slf4j
@RequestMapping("/admin/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 分页查询
     * @param messagePageQueryDTO
     * @return
     */
    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody MessagePageQueryDTO messagePageQueryDTO) {
        log.info("分页查询 {} ...", messagePageQueryDTO);
        messagePageQueryDTO.setOperation(10);
        PageResult pageResult = messageService.page(messagePageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据id查询帖子
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Message> getMessageById(@PathVariable Long id) {
        log.info("根据id查询帖子 {} ...", id);
        Message message = messageService.getMessageById(id);
        return Result.success(message);
    }

    /**
     * 根据id批量删除帖子
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Long> ids) {
        log.info("根据id批量删除帖子 {} ...", ids);
        messageService.deleteByIds(ids);
        return Result.success();
    }

}