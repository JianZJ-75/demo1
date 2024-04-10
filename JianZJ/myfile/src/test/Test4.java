package test;

import java.io.File;

/**
 * @Author JianZJ
 * @Date 2024/4/4 22:08
 */
public class Test4 {
    public static void main(String[] args) {
        /*
        * 需求:
        *       删除一个多级文件夹
        * */

        File src = new File("C:\\Users\\22798\\Desktop\\study");

        delete(src);

    }

    public static void delete(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (var i : files) {
                if (i.isFile())
                    i.delete();
                else
                    delete(i);
            }
        }
        file.delete();
    }
}
