package demo.convertstream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author JianZJ
 * @Date 2024/4/14 20:50
 */
public class ConvertStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /*
        * 利用字节流读取文件中的数据, 每次都一整行, 而且不能出现乱码
        *
        * 1. 字节流在读取中文的时候, 时会出现乱码的, 但是字符流可以搞定
        * 2. 字节流里面是没有读一整行的方法的, 只有字符缓冲流才能搞定
        * */

//        FileInputStream fis = new FileInputStream("myio\\src\\resource\\a.txt");
//        InputStreamReader isr = new InputStreamReader(fis);
//        BufferedReader br = new BufferedReader(isr);
//        String line;
//        while((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
//        br.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("myio\\src\\resource\\a.txt")));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();

    }
}
