package demo.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author JianZJ
 * @Date 2024/4/16 16:52
 */
public class PrintStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        * 字符打印流
        *       构造方法
        *               public PrintWriter(Write/File/String)                               关联字节输出流/文件/文件路径
        *               public PrintWriter(String fileName, Charset charset)                指定字符编码
        *               public PrintWriter(Write, boolean autoFlush)                        自动刷新
        *               public PrintWriter(Write out, boolean autoFlush, String encoding)   指定字符编码且自动刷新
        *       成员方法
        *               public void write(...)                                              常规方法：规则跟之前一样, 写出字节或者字符串
        *               public void println(Xxx xx)                                         特有方法：打印任意类型的数据并且换行
        *               public void print(Xxx xx)                                           特有方法：打印任意类型的数据, 不换行
        *               public void printf(String format, Object... args)                   特有方法：带有占位符的打印语句
        * */

        // 1. 创建字符打印流对象
        PrintWriter pw = new PrintWriter(new FileWriter("myio\\src\\resource\\a.txt", true), true);

        // 2. 写出数据
        pw.println();
        pw.write(100);
        pw.println();
        pw.println(97);
        pw.print(true);
        pw.println();
        pw.printf("%s爱上了%s\n", "hcc", "zyd");

        // 3. 释放资源
        pw.close();

    }
}
