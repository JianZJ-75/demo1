package com.mcbbs.controller.user;

import com.mcbbs.result.Result;
import com.mcbbs.service.PlateService;
import com.mcbbs.vo.UserPlateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:27
 */

@RestController("userPlateController")
@Slf4j
@RequestMapping("/user/plate")
public class PlateController {

    @Autowired
    private PlateService plateService;

    /**
     * 获取所有版块以及每个对应的最新帖子与用户信息
     * @return
     */
    @GetMapping
    public Result<List<UserPlateVO>> plateList() {
        log.info("正在查询版块...");
        List<UserPlateVO> list = plateService.getPlateWithNewMessageAndUser();
        return Result.success(list);
    }

    /**
     * 根据id查询版块
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<UserPlateVO> getPlateById(@PathVariable("id") Long id) {
        log.info("正在查询id为 {} 的版块...", id);
        UserPlateVO userPlateVO = plateService.getUserPlateById(id);
        return Result.success(userPlateVO);
    }

}