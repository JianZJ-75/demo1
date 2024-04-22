package iotest.test2;

import cn.hutool.core.util.ReUtil;

import java.io.*;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/21 20:50
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
        /*
        * 随机点名器3(学生独立完成)
        *
        * 需求:
        *       一个文件里面存储了班级同学的姓名, 每个姓名占一行
        *       要求通过程序实现随机点名器
        *       第三次必定是张三同学
        *
        * 运行效果:
        *       第一次运行程序: 随即同学姓名1
        *       第二次运行程序: 随即同学姓名2
        *       第三次运行程序: 张三
        * */

        File file = new File("myio\\src\\resource\\names.txt");

        StringBuilder sb = new StringBuilder();
        BufferedReader br1 = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br1.readLine()) != null) {
            sb.append(line);
        }
        br1.close();

        List<String> all = ReUtil.findAll("(...)-.-([0-9]{2})", sb, 1);

        BufferedReader br2 = new BufferedReader(new FileReader("myio\\src\\resource\\count.txt"));
        line = br2.readLine();
        br2.close();
        int cnt = Integer.parseInt(line);
        cnt++;

        if (cnt == 3) {
            System.out.println("张三");
        } else {
            Collections.shuffle(all);
            System.out.println(all.get(0));
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("myio\\src\\resource\\count.txt"));
        bw.write(cnt + "");
        bw.close();

    }
}
