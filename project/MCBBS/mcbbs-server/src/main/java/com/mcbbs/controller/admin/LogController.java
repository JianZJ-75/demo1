package com.mcbbs.controller.admin;

import com.mcbbs.dto.LogPageQueryDTO;
import com.mcbbs.dto.RemarkPageQueryDTO;
import com.mcbbs.entity.Log;
import com.mcbbs.entity.Remark;
import com.mcbbs.result.PageResult;
import com.mcbbs.result.Result;
import com.mcbbs.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/19 19:52
 */

@RestController
@Slf4j
@RequestMapping("/admin/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 分页查询
     * @param logPageQueryDTO
     * @return
     */
    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody LogPageQueryDTO logPageQueryDTO) {
        log.info("分页查询 {} ...", logPageQueryDTO);
        PageResult pageResult = logService.page(logPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据id查询日志
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Log> getLogById(@PathVariable Long id) {
        log.info("根据id查询日志 {} ...", id);
        Log log1 = logService.getLogById(id);
        return Result.success(log1);
    }

    /**
     * 根据id批量删除日志
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Long> ids) {
        log.info("根据id批量删除日志 {} ...", ids);
        logService.deleteByIds(ids);
        return Result.success();
    }

}