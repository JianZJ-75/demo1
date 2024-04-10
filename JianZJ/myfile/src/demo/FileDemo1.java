package demo;

import java.io.File;

/**
 * @Author JianZJ
 * @Date 2024/4/2 20:57
 */
public class FileDemo1 {
    public static void main(String[] args) {

        // 1.根据字符串表示的路径，变成File对象
        String str = "C:\\Users\\22798\\Desktop\\z.txt";
        File f1 = new File(str);
        System.out.println(f1);

        // 2.父级路径：C:\Users\22798\Desktop
        //   子级路径：z.txt
        String parent = "C:\\Users\\22798\\Desktop";
        String child = "z.txt";
        File f2 = new File(parent, child);
        System.out.println(f2);

        // /为转义字符 所以要打//
        // 不建议这个写法 Linux 的路径分隔符为 \ 不是 /
        File f3 = new File(parent + "//" + child);
        System.out.println(f3);

        // 3.把一个File表示的路径和String表示的路径进行拼接
        File parent2 = new File("C:\\Users\\22798\\Desktop");
        String child2 = "z.txt";
        File f4 = new File(parent2, child);
        System.out.println(f4);

    }
}
