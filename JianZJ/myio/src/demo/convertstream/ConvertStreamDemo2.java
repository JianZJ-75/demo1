package demo.convertstream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/**
 * @Author JianZJ
 * @Date 2024/4/14 20:49
 */
public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
        * 利用转换流按照指定字符编码写出
        * */

//        // 1. 创建转换流的对象
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myio\\src\\resource\\c.txt"));
//
//        // 2. 写出数据
//        osw.write("你好你好");
//
//        // 3. 释放资源
//        osw.close();

        // 1. 创建转换流的对象
        FileWriter fw = new FileWriter("myio\\src\\resource\\c.txt", Charset.forName("GBK"));

        // 2. 写出数据
        fw.write("你好你好");

        // 3. 释放资源
        fw.close();

    }
}
