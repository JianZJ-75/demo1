package IO.demo.CharStream;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/8 21:37
 */
public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
         * 第一步: 创建对象
         * public FileReader(File file)          创建字符输入流关联本地文件
         * public FileReader(String pathname)    创建字符输入流关联本地文件
         *
         * 第二步: 读取数据
         * public int read()                     读取数据, 读到末尾返回-1
         * public int read(char[] buffer)        读取多个数据, 读到末尾返回-1
         *
         * 第三步: 释放资源
         * public void close()                   释放资源/关流
         * */

        // 1. 创建对象
        FileReader fr = new FileReader("src\\IO\\resource\\a.txt");

        // 2. 读取数据
        char[] chars = new char[2];
        int len;
        // read(chars): 读取数据, 解码, 强转三步合并了, 把强转之后的字符放到数组当中
        // 空参的read + 强制类型抓换
        while ((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }

        // 3. 释放资源
        fr.close();

    }
}
