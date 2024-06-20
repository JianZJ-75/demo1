package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author JianZJ
 * @Date 2024/6/20 19:38
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        // 需要导入mysql-connector-j的jar包
        // 注册驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web", "root", "root");
        Statement statement = connection.createStatement();
        String sql = "select * from studentInfo";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getString("num"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("sex"));
            System.out.println(resultSet.getString("age"));
        }
        statement.close();
        connection.close();
    }
}