package com.jianzj.service.impl;

import com.jianzj.mapper.OperateLogMapper;
import com.jianzj.pojo.OperateLog;
import com.jianzj.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author JianZJ
 * @Date 2024/7/13 2:55
 */

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public void insert(OperateLog operateLog) {
        operateLogMapper.insert(operateLog);
    }
}