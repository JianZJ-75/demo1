package demo.bufferedstream;

import java.io.*;

/**
 * @Author JianZJ
 * @Date 2024/4/10 15:43
 */
public class BufferedStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        * 需求:
        *       利用字节缓冲流拷贝文件
        *
        * 字节缓冲输入流的构造方法:
        *       public BufferInputStream(InputStream is)
        *
        * 字节缓冲输出流的构造方法:
        *       public BufferedOutputStream(OutputStream os)
        * */

        // 1. 创建缓冲流对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("myio\\src\\resource\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("myio\\src\\resource\\f.txt"));

        // 2. 循环读取并写到目的地
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }

        // 3. 释放资源
        bos.close();
        bis.close();

    }
}
