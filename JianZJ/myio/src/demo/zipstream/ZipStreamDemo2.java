package demo.zipstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author JianZJ
 * @Date 2024/4/16 19:00
 */
public class ZipStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
        * 压缩流
        *       需求:
        *               把myio\\src\\resource\\a.txt打包成一个压缩包
        * */

        // 1. 创建File对象表示要压缩的文件
        File src = new File("myio\\src\\resource\\a.txt");
        // 2. 创建File对象表示压缩包的位置
        File dest = new File("myio\\src\\resource");
        // 3. 调用方法用来压缩
        toZip(src, dest);

    }

    /*
    * 作用: 压缩
    * 参数一: 表示要压缩的文件
    * 参数二: 表示压缩包的位置
    * */
    public static void toZip(File src, File dest) throws IOException {
        // 1. 创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dest, "a.zip")));
        // 2. 创建ZipEntry对象, 表示压缩包里面的每一个文件和文件夹
        // 参数: 压缩包里面的路径
        ZipEntry ze = new ZipEntry("a.txt");
        // 3. 把ZipEntry对象放到压缩包当中
        zos.putNextEntry(ze);
        // 4. 把src文件中的数据写到压缩包当中
        FileInputStream fis = new FileInputStream(src);
        int b;
        while((b = fis.read()) != -1) {
            zos.write(b);
        }
        fis.close();
        zos.closeEntry();
        zos.close();

    }

}