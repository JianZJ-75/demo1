package IO.demo.CharStream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/9 15:15
 */
public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        * 第一步: 创建对象
        *       public FileWriter(File file)                        创建字符输出流关联本地文件
        *       public FileWriter(String pathname)                  创建字符输出流关联本地文件
        *       public FileWriter(File file, boolean append)        创建字符输出流关联本地文件, 续写
        *       public FileWriter(String pathname, boolean append)  创建字符输出流关联本地文件, 续写
        *
        * 第二步: 写出数据
        *       void write(int c)                                   写出一个字符
        *       void write(String str)                              写出一个字符串
        *       void write(String str, int off, int len)            写出一个字符串的一部分
        *       void write(char[] cbuf)                             写出一个字符数组
        *       void write(char[] cbuf, int off, int len)           写出一个字符数组的一部分
        *
        * 第三步: 释放资源
        *       public void close()                                 释放资源/关流
        * */

        FileWriter fw = new FileWriter("src\\IO\\resource\\a.txt", true);

        fw.write("\r\n");
        fw.write(25105);

        fw.write("\r\n");
        fw.write("你好!!!");

        fw.write("\r\n");
        fw.write("你好!!!", 1, 3);

        char[] chars = {'a', 'b', 'c', 'd'};
        fw.write("\r\n");
        fw.write(chars);

        fw.write("\r\n");
        fw.write(chars, 2, 2);

        fw.close();

    }
}
