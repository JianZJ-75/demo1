package demo.input;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/7 17:11
 */
public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        * 字节输入流循环读取
        * */

        // 1. 创建对象
        FileInputStream fis = new FileInputStream("src\\IO\\resource\\a.txt");

        // 2. 循环读取
        // read: 表示读取数据, 而且是读取一个数据就移动一次指针
        int b;
        while ((b = fis.read()) != -1) {
            System.out.print((char) b);
        }
        // 如果写成以下写法, 则原本abcde会变成ace
//        while(fis.read() != -1) {
//            System.out.print((char) fis.read());
//        }

        // 3. 释放资源
        fis.close();

    }
}
