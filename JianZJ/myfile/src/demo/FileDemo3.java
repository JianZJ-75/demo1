package demo;

import java.io.File;
import java.util.Date;

/**
 * @Author JianZJ
 * @Date 2024/4/3 19:21
 */
public class FileDemo3 {
    public static void main(String[] args) {
        /*
        * public long length()              返回文件的大小(字节数量)
        * public String getAbsolutePath()   返回文件的绝对路径
        * public String getPath()           返回定义文件时使用的路径
        * public getName()                  返回文件的名称,带后缀
        * public long lastModified()        返回文件的最后修改时间(时间毫秒值)
        * */

        // 1.length 返回文件的大小(字节数量)
        // 细节1: 这个方法只能获取文件的大小,单位是字节
        // 如果单位是M, G, 可以不断地除以1024
        // 细节2: 这个方法无法获取文件下的大小
        // 如果我们要获取一个文件夹的大小, 需要把这个文件夹里面所有的文件大小都累加在一起
        File f1 = new File("C:\\Users\\22798\\Desktop\\z.txt");
        long len = f1.length();
        System.out.println(len);

        File f2 = new File("C:\\Users\\22798\\Desktop");
        long len2 = f2.length();
        System.out.println(len2);

        System.out.println("---------------------------");

        // 2.getAbsolutePath 返回文件的绝对路径
        File f3 = new File("C:\\Users\\22798\\Desktop\\z.txt");
        String path1 = f3.getAbsolutePath();
        System.out.println(path1);

        File f4 = new File("JianZJ\\src\\File\\demo\\FileDemo3");
        String path2 = f4.getAbsolutePath();
        System.out.println(path2);

        System.out.println("---------------------------");

        // 3.getPath() 返回定义文件时使用的路径
        File f5 = new File("C:\\Users\\22798\\Desktop\\z.txt");
        String path3 = f5.getPath();
        System.out.println(path3);

        File f6 = new File("JianZJ\\src\\File\\demo\\FileDemo3");
        String path4 = f6.getPath();
        System.out.println(path4);

        System.out.println("---------------------------");

        // 4.getName() 返回文件的名称,带后缀
        // 细节1:
        // z.txt:
        //       z 文件名
        //       txt 后缀名  扩展名
        // 细节2:
        // 文件夹: 返回的就是文件下的名字
        File f7 = new File("C:\\Users\\22798\\Desktop\\z.txt");
        String name1 = f7.getName();
        System.out.println(name1);

        File f8 = new File("C:\\Users\\22798\\Desktop");
        String name2 = f8.getName();
        System.out.println(name2);

        System.out.println("---------------------------");

        // 5.lastModified() 返回文件的最后修改时间(时间毫秒值)
        File f9 = new File("C:\\Users\\22798\\Desktop\\z.txt");
        long time = f9.lastModified();
        System.out.println(time);
        Date date = new Date(time); // 创建一个 Date 对象，参数为毫秒值
        System.out.println(date); // 打印实际时间

    }
}
