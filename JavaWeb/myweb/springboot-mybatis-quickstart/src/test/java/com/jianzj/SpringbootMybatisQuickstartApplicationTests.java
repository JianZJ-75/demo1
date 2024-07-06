package com.jianzj;

import com.jianzj.mapper.EmpMapper;
import com.jianzj.mapper.UserMapper;
import com.jianzj.pojo.Emp;
import com.jianzj.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Autowired
    EmpMapper empMapper;

    @Test
    public void testDelete() {
        empMapper.delete(7);
    }

    @Test
    public void testInsert() {
        Emp emp = new Emp();
        emp.setUsername("Tom");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
    }

    @Test
    public void testSelect() {
        Emp emp = empMapper.select(1);
        System.out.println(emp);
    }

    @Test
    public void testUpdate() {
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("Tom");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update(emp);
    }

    @Test
    public void testSelect2() {
        System.out.println(empMapper.selectBySubmit(null, (short) 1, null, null));
    }

    @Test
    public void testDelete1() {
        List<Integer> ids = Arrays.asList(12, 13, 14);
        empMapper.deleteByIds(ids);
    }

}
