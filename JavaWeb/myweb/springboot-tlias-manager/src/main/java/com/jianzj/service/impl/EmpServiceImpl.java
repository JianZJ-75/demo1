package com.jianzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jianzj.mapper.EmpMapper;
import com.jianzj.pojo.Emp;
import com.jianzj.pojo.PageBean;
import com.jianzj.service.EmpService;
import com.jianzj.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行查询
        // empList其实是分页查询结果的一个封装类, 将其转成List<Page>
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        // 封装对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        return pageBean;
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.add(emp);
    }

    @Override
    public Emp get(Integer id) {
        return empMapper.get(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.update(emp);
    }

    @Override
    public String login(Emp emp) {
        Emp tmp = empMapper.getByUsernameAndPassword(emp);
        if (tmp != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", tmp.getId());
            claims.put("name", tmp.getName());
            claims.put("username", tmp.getUsername());
            return JwtUtils.generateToken(claims);
        }
        return null;
    }
}