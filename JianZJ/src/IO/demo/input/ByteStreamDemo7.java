package IO.demo.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/7 20:55
 */
public class ByteStreamDemo7 {
    public static void main(String[] args) {
        /*
        *       利用try...catch...finally捕获拷贝文件中代码出现的异常
        * */

        // 1. 创建对象
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {

            // 1. 创建对象
            fis = new FileInputStream("src\\IO\\resource\\a.txt");
            fos = new FileOutputStream("src\\IO\\resource\\d.txt");

            // 2. 文件拷贝
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            // 3. 释放资源
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }
}
