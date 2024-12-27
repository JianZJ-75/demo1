package com.mcbbs.controller.user;

import com.mcbbs.constant.JwtClaimsConstant;
import com.mcbbs.dto.UserLoginDTO;
import com.mcbbs.entity.User;
import com.mcbbs.properties.JwtProperties;
import com.mcbbs.result.Result;
import com.mcbbs.service.UserService;
import com.mcbbs.utils.JwtUtil;
import com.mcbbs.vo.UserLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:24
 */

@RestController("userUserController")
@Slf4j
@RequestMapping("/user/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;

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
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户 {} 正在登陆...", userLoginDTO.getUsername());
        User user = userService.login(userLoginDTO);
        // 生成jwt
        Map<String , Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getSecretKey(),
                jwtProperties.getTtl(),
                claims
        );
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .token(token)
                .build();
        return Result.success(userLoginVO);
    }

    /**
     * 用户退出
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        log.info("登出...");
        return Result.success();
    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable("id") Long id) {
        log.info("正在查询id为 {} 的用户", id);
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        log.info("正在注册 {} ...", user);
        userService.register(user);
        return Result.success();
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        log.info("正在修改 {} ...", user);
        userService.update(user);
        return Result.success();
    }

}