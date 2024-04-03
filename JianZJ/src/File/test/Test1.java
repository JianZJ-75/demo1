package File.test;

import java.io.File;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/3 23:05
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        // 需求: 在当前模块下的aaa文件夹中创建一个a.txt文件

        File f1 = new File("src\\File\\aaa");
        f1.mkdirs();
        File f2 = new File(f1, "a.txt");
        boolean ok = f2.createNewFile();
        if (ok)
            System.out.println("yes");
        else
            System.out.println("no");

    }
}
