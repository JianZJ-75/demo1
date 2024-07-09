package com.jianzj.controller;

import com.jianzj.pojo.Emp;
import com.jianzj.pojo.PageBean;
import com.jianzj.pojo.Result;
import com.jianzj.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;

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
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    @GetMapping
    public Result pages(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        String name, Short gender,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询, 参数: " + page + ", "  + pageSize + ", " + name + ", " + gender + ", " + begin + ", " + end);

        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    /**
     * 批量删除员工
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable Integer... ids) {
        log.info("批量删除员工: " + Arrays.toString(ids));

        empService.deleteByIds(ids);

        return Result.success();
    }

    /**
     * 添加员工
     * @param emp
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("添加员工: " + emp);

        empService.add(emp);

        return Result.success();
    }

    /**
     * 根据ID查询员工信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public Result get(@PathVariable Integer id) {
        log.info("根据ID查询员工信息: {}" + id);

        Emp emp = empService.get(id);

        return Result.success(emp);
    }

    /**
     * 修改员工信息
     * @param emp
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工信息: {}" + emp.toString());

        empService.update(emp);

        return Result.success();
    }

}