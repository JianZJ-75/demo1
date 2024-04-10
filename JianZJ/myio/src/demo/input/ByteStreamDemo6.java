package demo.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/7 19:43
 */
public class ByteStreamDemo6 {
    public static void main(String[] args) throws IOException {
        /*
         * 练习:
         *       文件拷贝
         *       把 src\\IO\\resource\\a.txt 拷贝一份
         *
         * */

        // 获取当前时间戳
        long start = System.currentTimeMillis();

        // 1. 创建对象
        FileInputStream fis = new FileInputStream("src\\IO\\resource\\a.txt");
        FileOutputStream fos = new FileOutputStream("src\\IO\\resource\\d.txt");

        // 2. 文件拷贝
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        // 3. 释放资源
        fos.close();
        fis.close();

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}
