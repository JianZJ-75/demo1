package com.itheima.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.UserVO;

import java.util.List;

public interface IUserService extends IService<User> {
    void deductionBalance(Long id, Integer money);

    List<User> getUsers(UserQuery userQuery);

    UserVO getUserAndAddressesById(Long id);

    List<UserVO> getUserAndAddressesByIds(List<Long> ids);

    PageDTO<UserVO> pageQuery(UserQuery userQuery);
}
