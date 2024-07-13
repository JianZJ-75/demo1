package com.itheima.config;

import com.itheima.service.DeptService;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author JianZJ
 * @Date 2024/7/14 2:51
 */

@Configuration
public class CommonConfig {

    // 声明第三方bean
    @Bean // 将当前方法的返回值对象交给IOC容器管理, 称为IOC容器bean
          // 通过@Bean注解的name/value属性指定bean名称, 如果未指定, 默认是方法名
    public SAXReader saxReader(DeptService deptService) {
        System.out.println(deptService);
        return new SAXReader();
    }

}