package com.mcbbs.controller.user;

import com.mcbbs.dto.MessagePageQueryDTO;
import com.mcbbs.entity.Message;
import com.mcbbs.result.PageResult;
import com.mcbbs.result.Result;
import com.mcbbs.service.MessageService;
import com.mcbbs.vo.MessageAndPlateVO;
import com.mcbbs.vo.MessageAndRemarkVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:26
 */

@RestController("userMessageController")
@Slf4j
@RequestMapping("/user/message")
public class MessageController {

    /*
    * 用户发布帖子
    * 用户删除自己的帖子
    * 用户修改自己的帖子
    * 用户查看帖子
    *   单个
    *   分页 模糊()
    * */

    @Autowired
    private MessageService messageService;

    /**
     * 根据用户id查询帖子
     * @param id
     * @return
     */
    @GetMapping("/byUser/{id}")
    public Result<List<MessageAndPlateVO>> getMessagesByUserId(@PathVariable Long id) {
        log.info("根据用户id查询帖子 {} ...", id);
        List<MessageAndPlateVO> messageAndPlateVOS = messageService.getMessagesByUserId(id);
        return Result.success(messageAndPlateVOS);
    }

    /**
     * 分页查询
     * @param messagePageQueryDTO
     * @return
     */
    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody MessagePageQueryDTO messagePageQueryDTO) {
        log.info("分页查询: {} ...", messagePageQueryDTO);
        PageResult pageResult = messageService.page(messagePageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 新增帖子
     * @param message
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Message message) {
        log.info("新增帖子 {} ...", message);
        messageService.save(message);
        return Result.success();
    }

    /**
     * 根据帖子id获取帖子以及评论
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<MessageAndRemarkVO> getMessageById(@PathVariable("id") Long id) {
        log.info("根据id {} 获取帖子...", id);
        MessageAndRemarkVO messageAndRemarkVO = messageService.getMessageAndRemarkById(id);
        return Result.success(messageAndRemarkVO);
    }

    /**
     * 修改帖子
     * @param message
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Message message) {
        log.info("修改帖子 {} ...", message);
        messageService.update(message);
        return Result.success();
    }

    /**
     * 根据id删除帖子
     * @param id
     * @return
     */
    @DeleteMapping
    public Result deleteById(Long id) {
        log.info("根据id {} 删除帖子...", id);
        messageService.deleteById(id);
        return Result.success();
    }

}