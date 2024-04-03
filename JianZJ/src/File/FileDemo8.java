package File;

import java.io.File;

/**
 * @Author JianZJ
 * @Date 2024/4/3 21:22
 */
public class FileDemo8 {
    public static void main(String[] args) {
        /*
         * (掌握)public File[] listFiles()                    获取当前该路径下所有内容和
         * */

        // 1.创建File对象
        File f = new File("C:\\Users\\22798\\Desktop");
        // 2.需求: 打印里面所有的txt文件
        File[] files = f.listFiles();
        for (var file : files) {
            if (file.isFile() && file.getName().endsWith(".txt"))
                System.out.println(file);
        }
        
    }
}
