package demo.convertstream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @Author JianZJ
 * @Date 2024/4/14 20:49
 */
public class ConvertStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        * 利用转换流按照指定的字符编码读取(了解)
        *
        * 原因: 在JDK11中: 这种方式被淘汰了, 替代方案(掌握)
        * */

//        // 1. 创建对象并指定字符编码
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("myio\\src\\resource\\a.txt"), "GBK");
//
//        // 2. 读取数据
//        int b;
//        while ((b = isr.read()) != -1) {
//            System.out.print((char) b);
//        }
//
//        // 3. 释放资源
//        isr.close();

        // 1. 创建对象并指定字符编码
        FileReader fr = new FileReader("myio\\src\\resource\\a.txt", Charset.forName("GBK"));

        // 2. 读取数据
        int b;
        while ((b = fr.read()) != -1) {
            System.out.print((char) b);
        }

        // 3. 释放资源
        fr.close();

    }
}
