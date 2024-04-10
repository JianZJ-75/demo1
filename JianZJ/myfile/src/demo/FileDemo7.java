package demo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/4/3 20:56
 */
public class FileDemo7 {
    public static void main(String[] args) {
        /*
        * public static File[] listRoots()                  列出可用的文件系统根
        * public String[] list()                           获取当前该路径下所有内容
        * public String[] list(FilenameFilter filter)       利用文件名过滤器获取当前该路径下所有内容
        * */

        // 1.listRoots 获取系统中所有的盘符
        File[] list1 = File.listRoots();
        System.out.println(Arrays.toString(list1));

        // 2.list() 获取当前改路径下所有内容(仅仅能获得名字)
        File f1 = new File("C:\\Users\\22798\\Desktop");
        String[] list2 = f1.list();
        System.out.println(Arrays.toString(list2));

        // 3.list(FilenameFilter filter) 利用文件名过滤器获取当前该路径下所有内容
        // 需求: 获取文件夹里面所有的txt文件
        File f2 = new File("C:\\Users\\22798\\Desktop");
        // accept方法的形参, 依次表示文件夹里面的每一个文件或者文件夹的路径
        // 参数一: 父级路径
        // 参数二: 子级路径
        // 返回值: 如果返回值为true, 就表示当前路径保留
        //        如果返回值为false, 就表示当前路径舍弃不要
        String[] list3 = f1.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File src = new File(dir, name);
                return src.isFile() && name.endsWith(".txt");
            }
        });

        String[] list4 = f1.list((dir, name) -> new File(dir, name).isFile() && name.endsWith(".txt"));

        System.out.println(Arrays.toString(list3));

        System.out.println(Arrays.toString(list4));

    }
}
