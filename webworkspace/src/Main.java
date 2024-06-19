import servlet.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/web";
        String username = "zj";
        String password = "12345";

        //连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //执行sql的对象 用于执行sql并返回结果
        Statement statement = connection.createStatement();

        String sql = "show tables";

        //返回的结果集
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(resultSet);

        statement.close();
        connection.close();
//        Connection connection = null;
//        Statement statement = null;
//        List<Student> list = new ArrayList<>();
//        String url = "jdbc:mysql://localhost:3306/web";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(url, "zj", "12345");
//            statement = connection.createStatement();
//            String query = "select * from studentInfo";
//            ResultSet res = statement.executeQuery(query);
//            while (res.next()) {
//                Student student = new Student();
//                student.setNum(res.getString("num"));
//                student.setName(res.getString("name"));
//                student.setSex(Integer.parseInt(res.getString("sex")));
//                student.setAge(Integer.parseInt(res.getString("age")));
//                list.add(student);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (statement != null) statement.close();
//                if (connection != null) connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(list);
    }
}