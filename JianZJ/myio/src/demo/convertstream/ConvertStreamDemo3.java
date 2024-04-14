package demo.convertstream;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @Author JianZJ
 * @Date 2024/4/14 20:50
 */
public class ConvertStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        * 将本地文件中的GBK, 转成UTF-8
        * */

//        // JDK11以前的版本
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("myio\\src\\resource\\c.txt"), "GBK");
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myio\\src\\resource\\i.txt"), "UTF-8");
//        int b;
//        while ((b = isr.read()) != -1) {
//            osw.write(b);
//        }
//        osw.close();
//        isr.close();

        // 2. 替代方案
        FileReader fr = new FileReader("myio\\src\\resource\\c.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter("myio\\src\\resource\\i.txt", Charset.forName("UTF-8"));
        int b;
        while ((b = fr.read()) != -1) {
            fw.write(b);
        }
        fw.close();
        fr.close();

    }
}
