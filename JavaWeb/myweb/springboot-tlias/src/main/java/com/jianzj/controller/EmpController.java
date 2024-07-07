package com.jianzj.controller;

import com.jianzj.pojo.PageBean;
import com.jianzj.pojo.Result;
import com.jianzj.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author JianZJ
 * @Date 2024/7/8 1:19
 */

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping
    public Result pages(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("分页查询, 参数: " + page + ", "  + pageSize);

        PageBean pageBean = empService.page(page, pageSize);

        return Result.success(pageBean);
    }

}