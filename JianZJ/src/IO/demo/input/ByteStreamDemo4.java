package IO.demo.input;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

/**
 * @Author JianZJ
 * @Date 2024/4/7 17:21
 */
public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /*
        * 练习:
        *       文件拷贝
        *       把 src\\IO\\resource\\a.txt 拷贝一份
        *
        * 注意:
        *       选择一个比较小的文件, 不要太大, 大文件拷贝下一个视频会说
        * */

        // 1. 创建对象
        FileInputStream fis = new FileInputStream("src\\IO\\resource\\a.txt");
        FileOutputStream fos = new FileOutputStream("src\\IO\\resource\\c.txt");

        // 2. 拷贝
        // 核心思想: 边读边写
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }

        // 3. 释放资源
        // 规则: 先开的最后关闭
        fos.close();
        fis.close();

    }
}
