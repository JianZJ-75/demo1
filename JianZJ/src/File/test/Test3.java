package File.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/3 23:55
 */
public class Test3 {

    private static List<File> avis = new ArrayList<>();

    public static void main(String[] args) {
        /*
        * 需求:
        *       找到电脑中所有以avi结尾的电影
        *       (需要考虑子文件夹)
        * */

        File[] roots = File.listRoots();

        System.out.println(Arrays.toString(roots));

        for (var root : roots) {
            findAVI(root);
        }

        System.out.println(avis);

    }

    public static void findAVI(File file) {
        File[] files = file.listFiles();
        if (files == null)
            return;
        for (var i : files) {
            if (i.isDirectory())
                findAVI(i);
            else if (i.isFile() && i.getName().endsWith(".avi"))
                avis.add(i);
        }
    }
}
