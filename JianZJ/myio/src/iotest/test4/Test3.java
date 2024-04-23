package iotest.test4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author JianZJ
 * @Date 2024/4/23 22:04
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        // 1. 创建集合
        Properties prop = new Properties();
        // 2. 读取本地Properties文件里面的数据
        FileInputStream fis = new FileInputStream(new File("myio\\src\\resource\\a.properties"));
        prop.load(fis);
        fis.close();
        // 3. 打印集合
        System.out.println(prop);
    }
}
