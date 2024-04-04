package File.test;

import java.io.File;

/**
 * @Author JianZJ
 * @Date 2024/4/4 22:08
 */
public class Test5 {
    public static void main(String[] args) {
        /*
        * 需求:
        *       统计一个文件夹的总大小
        * */

        File src = new File("C:\\Users\\22798\\Desktop");

        long len = getLen(src);

        System.out.println(len + "B");
        System.out.println(len / 1024 + "KB");
        System.out.println(len / 1024 / 1024 + "MB");

    }

    public static long getLen(File src) {
        long len = 0;
        File[] files = src.listFiles();
        for (var file : files) {
            if (file.isFile())
                len += file.length();
            else
                len += getLen(file);
        }
        return len;
    }
}
