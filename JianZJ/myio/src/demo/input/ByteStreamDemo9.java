package demo.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/7 22:32
 */
public class ByteStreamDemo9 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
         *       JDK9: IO流中捕获异常的写法
         * */

        // 1. 创建对象
        FileInputStream fis = new FileInputStream("src\\IO\\resource\\a.txt");
        FileOutputStream fos = new FileOutputStream("src\\IO\\resource\\d.txt");

        try(fis; fos) {

            // 2. 文件拷贝
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
