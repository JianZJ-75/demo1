package demo.bufferedstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/10 16:15
 */
public class BufferedStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /*
         * 字符缓冲输出流:
         *       构造方法:
         *               public BufferedWriter(Writer r)
         *       特有方法:
         *               public void newline()          跨平台的换行
         * */

        // 1. 创建字符缓冲输出流的对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("myio\\src\\resource\\a.txt", true));

        // 2. 写出数据
        bw.write("31232132");
        bw.newLine();
        bw.write("hello!!");
        bw.newLine();

        // 3. 释放资源
        bw.close();

    }
}
