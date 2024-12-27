package com.mcbbs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mcbbs.entity.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author JianZJ
 * @Date 2024/11/13 20:32
 */

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
