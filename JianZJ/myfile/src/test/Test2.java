package test;

import java.io.File;

/**
 * @Author JianZJ
 * @Date 2024/4/3 23:46
 */
public class Test2 {
    public static void main(String[] args) {
        /*
        * 需求:
        *       定义一个方法找某一个文件夹中, 是否有以avi结尾的电影
        *       (暂时不需要考虑子文件夹)
        * */

        File f1 = new File("src\\File\\aaa");
        boolean b = haveAVI(f1);
        System.out.println(b);

    }

    public static boolean haveAVI(File file) {
        File[] files = file.listFiles((a, b) -> b.endsWith(".avi"));
        if (files == null || files.length == 0)
            return false;
        else
            return true;
    }
}
