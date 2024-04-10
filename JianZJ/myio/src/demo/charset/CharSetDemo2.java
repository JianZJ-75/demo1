package demo.charset;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/7 23:41
 */
public class CharSetDemo2 {
    public static void main(String[] args) throws IOException {
        // 1. 创建对象
        FileInputStream fis = new FileInputStream("src\\IO\\resource\\a.txt");
        FileOutputStream fos = new FileOutputStream("src\\IO\\resource\\e.txt");

        // 2. 拷贝
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }

        // 3. 释放资源
        fos.close();
        fis.close();

    }
}
