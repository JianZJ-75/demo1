package com.itheima.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author JianZJ
 * @Date 2024/7/21 1:13
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}