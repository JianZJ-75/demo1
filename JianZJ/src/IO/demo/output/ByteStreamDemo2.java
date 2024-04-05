package IO.demo.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/4/5 21:00
 */
public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
        *       字节输出流的细节:
        *           1. 创建字节流对象
        *               细节1: 参数是字符串表示的路径或者File对象都是可以的
        *               细节2: 如果文件不存在会创建一个新的文件, 但是要保证父级路径是存在的
        *               细节3: 如果文件已经存在, 则会清空文件
        *           2. 写数据
        *               细节: write方法的参数是整数, 但是实际上写到本地文件中的是整数在ASCII上对应的字符
        *           3. 释放资源
        *               细节: 每次使用完流之后都要释放资源
        *
        * */

        File file = new File("src\\IO\\resource\\b.txt");

        FileOutputStream fos = new FileOutputStream(file);

        fos.write("zj".getBytes());

        fos.close();

    }
}
