package com.mcbbs.controller.admin;

import com.mcbbs.dto.PlatePageQueryDTO;
import com.mcbbs.entity.Plate;
import com.mcbbs.result.PageResult;
import com.mcbbs.result.Result;
import com.mcbbs.service.PlateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:27
 */

@RestController("adminPlateController")
@Slf4j
@RequestMapping("/admin/plate")
public class PlateController {

    @Autowired
    private PlateService plateService;

    /**
     * 分页查询
     * @param platePageQueryDTO
     * @return
     */
    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody PlatePageQueryDTO platePageQueryDTO) {
        log.info("分页查询 {} ...", platePageQueryDTO);
        PageResult pageResult = plateService.page(platePageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据id查询单个版块
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Plate> getPlateById(@PathVariable("id") Long id) {
        log.info("根据id {} 查询单个版块...", id);
        Plate plate = plateService.getPlateById(id);
        return Result.success(plate);
    }

    /**
     * 添加单个版块
     * @param plate
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Plate plate) {
        log.info("添加单个版块 {} ...", plate);
        plateService.save(plate);
        return Result.success();
    }

    /**
     * 修改版块
     * @param plate
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Plate plate) {
        log.info("修改版块 {} ...", plate);
        plateService.update(plate);
        return Result.success();
    }

    /**
     * 根据id批量删除版块
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Long> ids) {
        log.info("根据id批量删除版块 {} ...", ids);
        plateService.deleteByIds(ids);
        return Result.success();
    }

}