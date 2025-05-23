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
    public static final String url = "jdbc:mysql://127.0.0.1:3306/web6";
    // 数据库账号
    public static final String user = "root";
    // 数据库密码
    public static final String password = "123456";
    // 头像存放地址
    public static final String repo = "C:\\Users\\a1813\\Desktop\\Java\\web123\\src\\main\\resources\\";
    // SQL添加新用户
    public static final String sqlAdd = "insert into user(username, pwd, photo) values (?,?,?)";
    // SQL删除博客
    public static final String sqlDel = "delete from blog where blogId = ?";
    // SQL 添加博客
    public static final String sqlAddBlog = "insert into blog(title, username, content, postTime, userId) values(?,?,?,now(),?)";

    // 加载头像
    public static void loadPhoto(String url, InputStream content) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(content);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(url));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        bis.close();
    }

}
