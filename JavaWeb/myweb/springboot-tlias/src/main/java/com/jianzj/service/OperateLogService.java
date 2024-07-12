package com.jianzj.service;

import com.jianzj.pojo.OperateLog;

public interface OperateLogService {

    /**
     * 添加操作日志
     * @param operateLog
     */
    void insert(OperateLog operateLog);

}
