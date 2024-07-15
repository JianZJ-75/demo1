package com.jianzj.service;

import com.jianzj.pojo.Dept;

import java.util.List;


public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据ID查询部门
     * @param id
     * @return
     */
    Dept searchById(Integer id);

    /**
     * 更新部门信息
     * @param dept
     */
    void update(Dept dept);
}
