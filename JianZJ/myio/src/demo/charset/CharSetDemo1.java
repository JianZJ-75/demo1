package demo.charset;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/7 22:55
 */
public class CharSetDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        * 字节流读取中文会出现乱码
        * */

        FileInputStream fis = new FileInputStream("src\\IO\\resource\\a.txt");

        int b;
        while ((b = fis.read()) != -1) {
            System.out.print((char) b);
        }

        fis.close();

    }
}
