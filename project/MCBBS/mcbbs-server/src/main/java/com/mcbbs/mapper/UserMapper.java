package com.mcbbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mcbbs.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:32
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
