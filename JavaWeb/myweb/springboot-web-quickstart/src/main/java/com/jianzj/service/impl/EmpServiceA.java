package com.jianzj.service.impl;

import com.jianzj.dao.EmpDao;
import com.jianzj.dao.impl.EmpDaoA;
import com.jianzj.pojo.Emp;
import com.jianzj.service.EmpService;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/5 23:44
 */
public class EmpServiceA implements EmpService {
    private EmpDao empDao = new EmpDaoA();
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
        empList.stream().forEach(emp -> {
            // 处理gender
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
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