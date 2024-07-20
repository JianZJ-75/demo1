package com.itheima.mp.service;

import com.itheima.mp.domain.po.User;
import com.itheima.mp.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/21 1:14
 */

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    void testSave() {
        User user = new User();
        user.setUsername("HouChenChen");
        user.setPassword("123");
        user.setPhone("18688990011");
        user.setBalance(200);
        user.setInfo("{\"age\": 24, \"intro\": \"英文老师\", \"gender\": \"female\"}");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userService.save(user);
    }

    @Test
    void testQuery() {
        List<User> users = userService.listByIds(List.of(1L, 2L, 4L));
        users.forEach(System.out::println);
    }

}