package com.jianzj.controller;

import com.jianzj.pojo.Dept;
import com.jianzj.pojo.Result;
import com.jianzj.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/8 1:19
 */

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */
//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");

        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门: " + id);

        deptService.delete(id);

        return Result.success();
    }

    /**
     * 添加部门
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门: " + dept.getName());

        deptService.add(dept);

        return Result.success();
    }

    /**
     * 根据ID查询部门
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public Result searchById(@PathVariable Integer id) {
        log.info("根据ID查询部门: " + id);

        Dept dept = deptService.searchById(id);

        return Result.success(dept);
    }

    /**
     * 更新部门信息
     * @param dept
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("更新部门信息" + dept.getId() + " : " + dept.getName());

        deptService.update(dept);

        return Result.success();
    }

}