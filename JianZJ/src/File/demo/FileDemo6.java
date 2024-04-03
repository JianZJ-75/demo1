package File.demo;

import java.io.File;

/**
 * @Author JianZJ
 * @Date 2024/4/3 20:46
 */
public class FileDemo6 {
    public static void main(String[] args) {
        // public File[] listFiles()    获取当前该路径下所有内容

        // 1.创建File对象
        File f1 = new File("C:\\Users\\22798\\Desktop");
        // 2.listFiles方法
        // 作用:
        //      获取文件夹里面的所有内容, 把所有的内容放到数组中返回
        File[] files = f1.listFiles();
        for (var file : files) {
            // file依次表示文件夹里面的每一个文件或者文件夹
            System.out.println(file);
        }

    }
}
