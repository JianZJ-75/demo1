package File.demo;

import java.io.File;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/3 19:51
 */
public class FileDemo4 {
    public static void main(String[] args) throws IOException {
        /*
        * public boolean createNewFile()    创建一个新的空的文件
        * public boolean mkdir()            创建单级文件夹
        * public boolean mkdirs()           创建多级文件夹
        * */

        // 1.createNewFile() 创建一个新的空的文件
        // 细节1:
        //      如果当前路径表示的文件是不存在的, 则创建成功, 方法返回true
        //      如果当前路径表示的文件是存在的, 则创建成功, 方法返回false
        // 细节2:
        //      如果父级路径是不存在的, 那么方法则会有异常IOException
        // 细节3:
        //      creatNewFile方法创建的一定是文件, 如果路径中不包含后缀名, 则创建一个没有后缀的文件
        File f1 = new File("C:\\Users\\22798\\Desktop\\zj.txt");
        boolean ok1 = f1.createNewFile();
        System.out.println(ok1);

        // 2.mkdir make Directory 文件夹(目录)
        // 细节1:
        //      windows当中路径是唯一的, 如果当前路径已经存在, 则创建失败, 返回false
        //      路径一定是唯一的, 如果该路径已经存在一个名为study的文件, 也无法创建成功
        // 细节2:
        //      mkdir方法只能创建单级文件夹, 无法创建多级文件夹
        File f2 = new File("C:\\Users\\22798\\Desktop\\study");
        boolean ok2 = f2.mkdir();
        System.out.println(ok2);

        // 3.mkdirs 创建多级文件夹
        // 细节1:
        //      既可以创建单级的, 又可以创建多级的文件夹
        File f3 = new File("C:\\Users\\22798\\Desktop\\study\\zj\\zj");
        boolean ok3 = f3.mkdirs();
        System.out.println(ok3);

    }
}
