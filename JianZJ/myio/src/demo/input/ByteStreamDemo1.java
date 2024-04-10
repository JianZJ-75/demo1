package demo.input;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/5 23:01
 */
public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
         * 演示: 字节输入流FileInputStream
         * 实现需求: 读取文件中的数据(暂时不写中文)
         *
         * 实现步骤:
         *       创建对象
         *       读取数据
         *       释放资源
         * */

        // 1. 创建对象
        FileInputStream fis = new FileInputStream("src\\IO\\resource\\a.txt");

        // 2. 读取数据
        int b;
        b = fis.read();
        System.out.println((char) b);

        // 3. 释放资源
        fis.close();

    }
}
