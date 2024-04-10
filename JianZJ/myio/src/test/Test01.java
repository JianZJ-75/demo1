package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/9 17:16
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        /*
        * 拷贝一个文件夹, 考虑子文件夹
        * */

        // 1. 创建对象标识数据源
        File src = new File("src\\IO\\resource");

        // 2. 创建对象标识目的地
        File dest = new File("src\\IO\\copy");

        // 3. 调用方法开始拷贝
        copydir(src, dest);

    }

    private static void copydir(File src, File dest) throws IOException {
        dest.mkdirs();
        // 1. 进入数据源
        File[] files = src.listFiles();
        // 2. 遍历数组
        for (File file : files) {
            if (file.isFile()) {
                // 3. 判断文件, 拷贝
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                byte[] bytes = new byte[1024];
                int len;
                while((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                fos.close();
                fis.close();
            } else {
                // 4. 判断文件夹, 递归
                copydir(file, new File(dest, file.getName()));
            }
        }
    }
}
