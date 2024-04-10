package IO.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/9 17:32
 */
public class Test02 {
    public static void main(String[] args) throws IOException {
        /*
        * 为了保证文件的安全性, 就需要对原始文件进行加密储存, 再使用的时候再对其进行解密处理
        * 加密原理:
        *       对原始文件中的每一个字节数据进行更改, 然后将更改以后的数据存储到新的文件中
        * 解密原理:
        *       读取加密之后的文件, 按照加密的规则反向操作, 变成原始文件
        *
        * ^: 异或
        *   两边相同: false
        *   两边不同: true
        * */

        // 解密只需将加密的文件再进行一次异或

        // 1. 创建对象关联原始文件
        FileInputStream fis = new FileInputStream("src\\IO\\resource\\75.jpg");

        // 2. 创建对象关联加密文件
        FileOutputStream fos = new FileOutputStream("src\\IO\\resource\\ency.jpg");

        // 3. 加密处理
        final int K = 100;
        int b;
        while((b = fis.read()) != -1) {
            fos.write(b);
        }

        // 4. 释放资源
        fos.close();
        fis.close();

    }
}

