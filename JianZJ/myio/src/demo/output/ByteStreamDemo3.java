package demo.output;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/5 21:17
 */
public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        * void write(int b)                         一次写一个字节数据
        * void write(byte[] b)                      一次写一个字节数组数据
        * void write(byte[] b, int off, int len)    一次写一个字节数组的部分数据
        * 参数一:
        *       数组
        * 参数二:
        *       起始索引
        * 参数三:
        *       个数
        * */

        // 1. 创建对象
        FileOutputStream fos = new FileOutputStream("src\\IO\\resource\\a.txt");

        // 2. 写出数据
        fos.write(97);

        byte[] bytes = {100, 101, 102, 103, 104, 105};
        fos.write(bytes);

        fos.write(bytes, 2, 2);

        // 3. 释放资源
        fos.close();

    }
}
