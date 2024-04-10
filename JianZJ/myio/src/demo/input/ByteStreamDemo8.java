package demo.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/7 22:27
 */
public class ByteStreamDemo8 {
    public static void main(String[] args) {
        /*
        *       JDK7: IO流中捕获异常的写法
        *
        *       try后面的小括号中写创建对象的代码
        *           注意: 只有实现了AutoCloseable接口的类, 才能在小括号中创建对象
        *       try() {
        *
        *       } catch {
        *
        *       }
        *
        * */

        // 1. 创建对象
        try(FileInputStream fis = new FileInputStream("src\\IO\\resource\\a.txt");
            FileOutputStream fos = new FileOutputStream("src\\IO\\resource\\d.txt")) {

            // 2. 文件拷贝
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
