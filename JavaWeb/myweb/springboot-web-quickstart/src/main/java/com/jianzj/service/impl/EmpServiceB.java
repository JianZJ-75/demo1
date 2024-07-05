package com.jianzj.service.impl;

import com.jianzj.dao.EmpDao;
import com.jianzj.pojo.Emp;
import com.jianzj.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/6 0:10
 */
//@Component // 将当前类交给IOC容器管理, 成为IOC容器中的bean对象
public class EmpServiceB implements EmpService {

    @Autowired // 运行时, IOC容器会提供该类型的bean对象, 并赋值给该变量 - 依赖注入
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
        empList.stream().forEach(emp -> {
            // 处理gender
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男士");
            } else if ("2".equals(gender)) {
                emp.setGender("女士");
            }

            // 处理job
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}