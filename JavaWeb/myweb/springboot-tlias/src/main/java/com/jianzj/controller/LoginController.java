package com.jianzj.controller;

import com.jianzj.pojo.Emp;
import com.jianzj.pojo.Result;
import com.jianzj.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author JianZJ
 * @Date 2024/7/11 1:25
 */

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    /**
     * 登陆验证
     * @param emp
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登陆验证: {}" + emp);

        String res = empService.login(emp);

        return res != null ? Result.success(res) : Result.error("用户名或密码错误!");
    }

}