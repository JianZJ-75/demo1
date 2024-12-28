package com.itheima.mp.service;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.po.UserInfo;
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
        user.setInfo(UserInfo.of(24, "英文老师", "female"));
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userService.save(user);
    }

    @Test
    void testQuery() {
        List<User> users = userService.listByIds(List.of(1L, 2L, 4L));
        users.forEach(System.out::println);
    }

    @Test
    void testPageQuery() {
        int pageNo = 1, pageSize = 2;
        Page<User> page = new Page<>(pageNo, pageSize);
        page.addOrder(new OrderItem("balance", true));
        page.addOrder(new OrderItem("id", true));
        page = userService.page(page);
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

}