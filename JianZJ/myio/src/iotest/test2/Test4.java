package iotest.test2;

import java.io.*;
import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/4/21 20:52
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        /*
         * 随机点名器4(学生独立完成)
         *
         * 需求:
         *      一个文件里面存储了班级同学的姓名, 每个姓名占一行
         *      要求通过程序实现随机点名器
         *
         * 运行效果:
         *      被点到的学生不会再被点到
         *      如果班级中所有的学生都点完了, 需要自动地重新开启第二轮点名
         *      细节1: 假设班级有10个学生, 每一轮中每一位学生只能被点到一次, 程序运行10次, 第一轮结束
         *      细节2: 第11次运行的时候, 我们自己不需要手动操作本地文件, 要求程序自动开始第二轮点名
         * */

        File src = new File("myio\\src\\resource\\names.txt");
        File backups = new File("myio\\src\\resource\\backups.txt");

        // 读取数据
        List<String> names = getData(src);

        // 点名
        if (names.size() == 0) {
            names = getData(backups);
            writeData(names, src, false);
            backups.delete();
        }
        Collections.shuffle(names);
        String student = names.remove(0);
        System.out.println(student);

        // 重新存入数据
        writeData(student, backups, true);
        writeData(names, src, false);

    }

    private static void writeData(String name, File backups, boolean append) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(backups, append));
        bw.write(name);
        bw.newLine();
        bw.close();
    }

    private static void writeData(List<String> names, File backups, boolean append) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(backups, append));
        for (var name : names) {
            bw.write(name);
            bw.newLine();
        }
        bw.close();
    }

    private static List<String> getData(File src) throws IOException {
        List<String> names = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(src));
        String line;
        while ((line = br.readLine()) != null) {
            names.add(line);
        }
        br.close();
        return names;
    }

}