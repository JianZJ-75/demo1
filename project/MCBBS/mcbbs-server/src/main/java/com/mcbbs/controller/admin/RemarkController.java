package com.mcbbs.controller.admin;

import com.mcbbs.dto.MessagePageQueryDTO;
import com.mcbbs.dto.RemarkPageQueryDTO;
import com.mcbbs.entity.Message;
import com.mcbbs.entity.Remark;
import com.mcbbs.result.PageResult;
import com.mcbbs.result.Result;
import com.mcbbs.service.RemarkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:25
 */

@RestController("adminRemarkController")
@Slf4j
@RequestMapping("/admin/remark")
public class RemarkController {

    @Autowired
    private RemarkService remarkService;

    /**
     * 分页查询
     * @param remarkPageQueryDTO
     * @return
     */
    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody RemarkPageQueryDTO remarkPageQueryDTO) {
        log.info("分页查询 {} ...", remarkPageQueryDTO);
        PageResult pageResult = remarkService.page(remarkPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Remark> getRemarkById(@PathVariable Long id) {
        log.info("根据id查询评论 {} ...", id);
        Remark remark = remarkService.getRemarkById(id);
        return Result.success(remark);
    }

    /**
     * 根据id批量删除评论
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Long> ids) {
        log.info("根据id批量删除评论 {} ...", ids);
        remarkService.deleteByIds(ids);
        return Result.success();
    }

}