package com.jianzj.dao.impl;

import com.jianzj.dao.EmpDao;
import com.jianzj.pojo.Emp;
import com.jianzj.util.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/5 23:43
 */

//@Component // 将当前类交给IOC容器管理, 成为IOC容器中的bean对象
@Repository
public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        // 加载并解析XML
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}