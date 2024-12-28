package com.itheima.mp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import com.itheima.mp.domain.dto.PageDTO;
import com.itheima.mp.domain.po.Address;
import com.itheima.mp.domain.po.User;
import com.itheima.mp.domain.query.UserQuery;
import com.itheima.mp.domain.vo.AddressVO;
import com.itheima.mp.domain.vo.UserVO;
import com.itheima.mp.enums.UserStatus;
import com.itheima.mp.mapper.UserMapper;
import com.itheima.mp.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author JianZJ
 * @Date 2024/7/21 1:13
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public void deductionBalance(Long id, Integer money) {
        // 查询用户
        User user = this.getById(id);
        // 检验用户状态
        if (user == null || user.getStatus() == UserStatus.FREEZE) {
            throw new RuntimeException("用户状态异常");
        }
        // 校验用户余额
        if (money > user.getBalance()) {
            throw new RuntimeException("用户余额不足");
        }
        // 扣减余额
        Integer remainBalance = money - user.getBalance();
        lambdaUpdate()
                .set(User::getBalance, remainBalance)
                .set(remainBalance == 0, User::getStatus, 2)
                .eq(User::getId, id)
                .eq(User::getBalance, user.getBalance()) // 乐观锁 或者 悲观锁(事务)
                .update();
    }

    @Override
    public List<User> getUsers(UserQuery userQuery) {
        return lambdaQuery()
                .like(userQuery.getName() != null, User::getUsername, userQuery.getName())
                .eq(userQuery.getStatus() != null, User::getStatus, userQuery.getStatus())
                .ge(userQuery.getMinBalance() != null, User::getBalance, userQuery.getMinBalance())
                .le(userQuery.getMaxBalance() != null, User::getBalance, userQuery.getMaxBalance())
                .list();
    }

    @Override
    public UserVO getUserAndAddressesById(Long id) {
        User user = getById(id);
        // 检查用户状态
        if (user == null || user.getStatus() == UserStatus.FREEZE) {
            throw new RuntimeException("用户状态异常");
        }
        // 封装
        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        List<Address> addresses = Db.lambdaQuery(Address.class)
                .eq(Address::getUserId, id)
                .list();
        if (CollUtil.isNotEmpty(addresses)) {
            userVO.setAddresses(BeanUtil.copyToList(addresses, AddressVO.class));
        }
        return userVO;
    }

    @Override
    public List<UserVO> getUserAndAddressesByIds(List<Long> ids) {
        // 判断ids能否查到数据
        List<User> users = listByIds(ids);
        if (CollUtil.isEmpty(users)) {
            return Collections.EMPTY_LIST;
        }
        // 获取用户id集合
        List<Long> userIds = users.stream().map(User::getId).collect(Collectors.toList());
        // 查询address
        List<Address> addresses = Db.lambdaQuery(Address.class)
                .in(Address::getUserId, userIds)
                .list();
        // 转换vo
        List<AddressVO> addressVOList = BeanUtil.copyToList(addresses, AddressVO.class);
        // 分组
        Map<Long, List<AddressVO>> map = new HashMap<>();
        if (CollUtil.isNotEmpty(addressVOList)) {
            map = addressVOList.stream().collect(Collectors.groupingBy(AddressVO::getUserId));
        }
        // 转换userVO返回
        List<UserVO> userVOList = new ArrayList<>(users.size());
        for (User user : users) {
            UserVO vo = BeanUtil.copyProperties(user, UserVO.class);
            vo.setAddresses(map.get(vo.getId()));
            userVOList.add(vo);
        }
        return userVOList;
    }

    @Override
    public PageDTO<UserVO> pageQuery(UserQuery userQuery) {
        // 分页条件
        Page<User> page = new Page<>(userQuery.getPageNo(), userQuery.getPageSize());
        // 排序条件
        if (StrUtil.isNotBlank(userQuery.getSortBy())) {
            page.addOrder(new OrderItem(userQuery.getSortBy(), userQuery.getIsAsc()));
        } else {
            page.addOrder(new OrderItem("update_time", false));
        }
        // 查询
        Page<User> p = lambdaQuery()
                .like(userQuery.getName() != null, User::getUsername, userQuery.getName())
                .eq(userQuery.getStatus() != null, User::getStatus, userQuery.getStatus())
                .page(page);
        // 处理数据
        PageDTO<UserVO> pageDTO = new PageDTO<>();
        pageDTO.setTotal(p.getTotal());
        pageDTO.setPages(p.getPages());
        List<User> users = p.getRecords();
        if (CollUtil.isEmpty(users)) {
            pageDTO.setList(Collections.EMPTY_LIST);
        } else {
            pageDTO.setList(BeanUtil.copyToList(users, UserVO.class));
        }
        return pageDTO;
    }
}