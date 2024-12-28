package util;

import java.io.*;

/**
 * @Author JianZJ
 * @Date 2024/6/29 20:17
 */
public class UtilTools {

    // jdbc驱动类名
    public static final String className = "com.mysql.cj.jdbc.Driver";
    // 数据库地址
//    public static final String url = "jdbc:mysql://localhost:3306/web6";
    public static final String url = "jdbc:mysql://192.168.117.2:3306/web6";
    // 数据库账号
    public static final String user = "root";
    // 数据库密码
    public static final String password = "root";
    // SQL查找用户
    public static final String checkSql = "select * from user where username = ?";
    // SQL删除用户
    public static final String deleteSql = "delete from user where username = ?";
    // SQL添加新用户
    public static final String sqlAdd = "insert into user(username, pwd, photo) values (?,?,?)";
    // SQL删除博客
    public static final String sqlDel = "delete from blog where blogId = ?";
    // SQL添加博客
    public static final String sqlAddBlog = "insert into blog(title, username, content, postTime) values(?,?,?,now())";

}
