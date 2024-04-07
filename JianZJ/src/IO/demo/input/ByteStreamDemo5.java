package IO.demo.input;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/7 19:23
 */
public class ByteStreamDemo5 {
    public static void main(String[] args) throws IOException {
        /*
        * public int read(byte[] buffer)    一次读取一个字节数组数据
        * */

        // 1. 创建对象
        FileInputStream fis = new FileInputStream("src\\IO\\resource\\b.txt");

        // 2. 读取数据
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) > 0) {
            System.out.println(new String(bytes, 0, len));
        }

        // 3. 释放资源
        fis.close();

    }
}
