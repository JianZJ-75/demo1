package com.jianzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jianzj.mapper.EmpMapper;
import com.jianzj.pojo.Emp;
import com.jianzj.pojo.PageBean;
import com.jianzj.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/8 1:21
 */

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        // 获取总记录数
//        Long count = empMapper.count();
//
//        // 获取分页查询结果
//        List<Emp> empList = empMapper.page((page - 1) * pageSize, pageSize);
//
//        // 封装
//        PageBean pageBean = new PageBean(count, empList);
//
//        return pageBean;
//    }

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行查询
        // empList其实是分页查询结果的一个封装类, 将其转成List<Page>
        List<Emp> empList = empMapper.list();
        Page<Emp> p = (Page<Emp>) empList;
        // 封装对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        return pageBean;
    }

}