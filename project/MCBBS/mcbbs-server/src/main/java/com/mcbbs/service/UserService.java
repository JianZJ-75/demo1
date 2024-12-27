package com.mcbbs.service;

import com.mcbbs.dto.UserLoginDTO;
import com.mcbbs.dto.UserPageQueryDTO;
import com.mcbbs.entity.User;
import com.mcbbs.result.PageResult;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:08
 */

public interface UserService {

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 注册用户
     * @param user
     */
    void register(User user);

    /**
     * 修改用户信息
     * @param user
     */
    void update(User user);

    /**
     * 获取登陆用户信息
     * @return
     */
    User load();

    /**
     * 分页查询
     * @param userPageQueryDTO
     * @return
     */
    PageResult page(UserPageQueryDTO userPageQueryDTO);

    /**
     * 修改密码
     * @param user
     */
    void updatePassword(User user);

    /**
     * 切换用户身份
     * @param id
     */
    void switchRole(Long id);

    /**
     * 根据id批量删除用户
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 验证身份
     * @param userId
     * @return
     */
    User test(Long userId);
}
