package com.jianzj.service;

import com.jianzj.pojo.Emp;
import com.jianzj.pojo.PageBean;

import java.time.LocalDate;

public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param name
     * @param gender
     * @param begin
     * @param end
     * @return
     */
    PageBean page(Integer page,
                  Integer pageSize,
                  String name, Short gender,
                  LocalDate begin,
                  LocalDate end);


    /**
     * 批量删除员工
     * @param ids
     */
    void deleteByIds(Integer[] ids);

    /**
     * 添加员工
     * @param emp
     */
    void add(Emp emp);

    /**
     * 根据ID查询员工信息
     * @param id
     * @return
     */
    Emp get(Integer id);

    /**
     * 修改员工信息
     * @param emp
     */
    void update(Emp emp);

    /**
     * 登陆验证
     * @param emp
     * @return
     */
    String login(Emp emp);
}
