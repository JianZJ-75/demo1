package servlet;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/19 14:27
 */
@WebServlet(name = "WebTest4", urlPatterns = "/WebTest4")
public class WebTest4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        Connection connection = null;
        Statement statement = null;
        List<Student> list = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/web";
        try {
            // 注册驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立数据库连接
            connection = DriverManager.getConnection(url, "zj", "12345");
            // 执行sql语句并返回结果
            statement = connection.createStatement();
            String query = "select * from studentInfo";
            ResultSet res = statement.executeQuery(query);
            while (res.next()) {
                Student student = new Student();
                student.setNum(res.getString("num"));
                student.setName(res.getString("name"));
                student.setSex(Integer.parseInt(res.getString("sex")));
                student.setAge(Integer.parseInt(res.getString("age")));
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        pw.println(JSON.toJSONString(list));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
