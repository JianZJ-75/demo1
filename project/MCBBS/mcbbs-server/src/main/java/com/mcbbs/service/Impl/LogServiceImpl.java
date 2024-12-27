package com.mcbbs.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mcbbs.annotation.AutoFill;
import com.mcbbs.context.BaseContext;
import com.mcbbs.dto.LogPageQueryDTO;
import com.mcbbs.dto.RemarkPageQueryDTO;
import com.mcbbs.entity.Log;
import com.mcbbs.entity.Remark;
import com.mcbbs.entity.User;
import com.mcbbs.enumeration.OperationType;
import com.mcbbs.mapper.LogMapper;
import com.mcbbs.mapper.UserMapper;
import com.mcbbs.result.PageResult;
import com.mcbbs.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

/**
 * @Author JianZJ
 * @Date 2024/11/13 21:06
 */

@Service
@Slf4j
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
    @Autowired
    private UserMapper userMapper;

    @AutoFill(OperationType.LOG)
    @Override
    public void add(Log build) {
        logMapper.insert(build);
    }

    public LambdaQueryWrapper<Log> getWrapper(LogPageQueryDTO logPageQueryDTO) {
        LambdaQueryWrapper<Log> wrapper = new LambdaQueryWrapper<>();
        String keyWord = logPageQueryDTO.getKeyWord();
        if (keyWord != null && !keyWord.isEmpty()) {
            List<User> users = userMapper.selectList(
                    new LambdaQueryWrapper<User>()
                            .like(User::getUsername, keyWord)
            );
            List<Long> list = users.stream().map(i -> i.getId()).toList();
            // 存在就查, 不存在就查不到
            if (list != null && list.size() > 0) {
                wrapper.in(Log::getUserId, list);
            } else {
                wrapper.eq(Log::getUserId, 0);
            }
        }
        wrapper.orderByDesc(Log::getOperateTime);
        return wrapper;
    }


    @Override
    public PageResult page(LogPageQueryDTO logPageQueryDTO) {
        // 处理默认值
        if (logPageQueryDTO.getPage() == null) {
            logPageQueryDTO.setPage(0);
        }
        if (logPageQueryDTO.getPageSize() == null) {
            logPageQueryDTO.setPageSize(10);
        }
        Page<Log> page = logMapper.selectPage(
                new Page<>(logPageQueryDTO.getPage(), logPageQueryDTO.getPageSize()),
                getWrapper(logPageQueryDTO)
        );
        return new PageResult(page.getTotal(), page.getPages(), page.getRecords());
    }

    @Override
    public Log getLogById(Long id) {
        return logMapper.selectById(id);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        logMapper.deleteBatchIds(ids);
    }
}