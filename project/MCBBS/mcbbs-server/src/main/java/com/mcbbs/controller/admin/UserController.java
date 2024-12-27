package com.mcbbs.controller.admin;

import com.mcbbs.dto.UserPageQueryDTO;
import com.mcbbs.entity.User;
import com.mcbbs.result.PageResult;
import com.mcbbs.result.Result;
import com.mcbbs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:24
 */

@RestController("adminUserController")
@Slf4j
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取登陆用户信息
     * @return
     */
    @GetMapping
    public Result<User> load() {
        log.info("获取登陆用户信息...");
        User user = userService.load();
        return Result.success(user);
    }

    /**
     * 分页查询
     * @param userPageQueryDTO
     * @return
     */
    @PostMapping("/page")
    public Result<PageResult> page(@RequestBody UserPageQueryDTO userPageQueryDTO) {
        log.info("分页查询 {} ...", userPageQueryDTO);
        PageResult pageResult = userService.page(userPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @PutMapping("/update/password")
    public Result updatePassword(@RequestBody User user) {
        log.info("修改密码 {} ...", user);
        userService.updatePassword(user);
        return Result.success();
    }

    /**
     * 切换用户身份
     * @param id
     * @return
     */
    @PutMapping("/switch")
    public Result switchRole(Long id) {
        log.info("切换用户身份 {}...", id);
        userService.switchRole(id);
        return Result.success();
    }

    /**
     * 根据id批量删除用户
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Long> ids) {
        log.info("根据id批量删除用户 {} ...", ids);
        userService.deleteByIds(ids);
        return Result.success();
    }

}