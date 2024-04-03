package File.demo;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/4/3 21:26
 */
public class FileDemo9 {
    public static void main(String[] args) {
        /*
         * public Filep[] listFiles(FileFilter filter)       利用文件名过滤器获取当前该路径下所有内容
         * public File[] listFiles(FilenameFilter filter)    利用文件名过滤器获取当前该路径下所有内容
         * */

        // 创建File对象
        File f = new File("C:\\Users\\22798\\Desktop");
        // 调用listFiles
        File[] list = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        System.out.println(Arrays.toString(list));

        // 调用listFiles
        File[] files = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".txt");
            }
        });

        System.out.println(Arrays.toString(files));

    }
}
