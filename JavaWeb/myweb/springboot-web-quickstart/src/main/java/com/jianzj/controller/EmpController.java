package com.jianzj.controller;

import com.jianzj.pojo.Emp;
import com.jianzj.pojo.Result;
import com.jianzj.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/5 22:51
 */

@RestController
public class EmpController {

    @Autowired // 运行时, IOC容器会提供该类型的bean对象, 并赋值给该变量 - 依赖注入
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {
        List<Emp> empList = empService.listEmp();
        // 响应数据
        return Result.success(empList);
    }

//    @RequestMapping("/listEmp")
//    public Result list() {
//        // 加载并解析XML
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        System.out.println(file);
//        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//        // 对数据进行转换处理 - gender, job
//        empList.stream().forEach(emp -> {
//            // 处理gender
//            String gender = emp.getGender();
//            if ("1".equals(gender)) {
//                emp.setGender("男");
//            } else if ("2".equals(gender)) {
//                emp.setGender("女");
//            }
//
//            // 处理job
//            String job = emp.getJob();
//            if ("1".equals(job)) {
//                emp.setJob("讲师");
//            } else if ("2".equals(job)) {
//                emp.setJob("班主任");
//            } else if ("3".equals(job)) {
//                emp.setJob("就业指导");
//            }
//        });
//        // 响应数据
//        return Result.success(empList);
//    }
}