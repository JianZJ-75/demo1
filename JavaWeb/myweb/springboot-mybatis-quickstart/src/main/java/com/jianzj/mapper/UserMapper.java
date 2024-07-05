package com.jianzj.mapper;

import com.jianzj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper // 在运行时, 会自动生成该接口的实现类对象(代理对象), 并且将对象交给IOC容器管理
public interface UserMapper {
    @Select("select * from user")
    public List<User> list();
}
