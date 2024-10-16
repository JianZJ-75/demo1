package demo.output;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/5 21:25
 */
public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /*
        * 换行写:
        *       再次写出一个换行符就可以了
        *       windows:    \r\n
        *       Linux:      \n
        *       Mac:        \r
        * 细节:
        *       在windows操作系统中, java对回车换行进行了优化
        *       虽然完整的是\r\n, 但是我们写其中一个\r或者\n
        *       java也可以实现换行, 因为java在底层会补全
        * 建议:
        *       不要省略, 还是写全了
        *
        * 续写:
        *       如果想要续写, 打开续写开关即可
        *       开关位置: 创建对象的第二个参数
        *       默认false: 表示关闭续写, 此时创建对象会清空文件
        *       手动传递true: 表示打开续写, 此时创建对象不会清空文件
        * */

        // 1. 创建对象
        FileOutputStream fos = new FileOutputStream("src\\IO\\resource\\a.txt", true);

        // 2. 写出数据
        fos.write("hello!".getBytes());

        fos.write("\r\n".getBytes());

        fos.write("I am zj.".getBytes());

        fos.write("\r\n".getBytes());

        // 3. 释放资源
        fos.close();

    }
}
