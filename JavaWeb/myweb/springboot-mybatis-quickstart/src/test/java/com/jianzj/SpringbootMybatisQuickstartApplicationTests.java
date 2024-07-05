package com.jianzj;

import com.jianzj.mapper.UserMapper;
import com.jianzj.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest // springboot整合单元测试的注解
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {
        userMapper.list().stream().forEach(user ->
                System.out.println(user));
    }

    @Test
    public void testJdbc() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mybatis";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        Statement statement = connection.createStatement();
        String sql = "select * from user";
        ResultSet res = statement.executeQuery(sql);
        List<User> users = new ArrayList<>();
        while (res.next()) {
            User user = new User();
            user.setId(res.getInt("id"));
            user.setName(res.getString("name"));
            user.setAge(res.getShort("age"));
            user.setGender(res.getShort("gender"));
            user.setPhone(res.getString("phone"));
            users.add(user);
        }
        statement.close();
        connection.close();
        System.out.println(users);
    }

}
