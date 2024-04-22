package iotest.test2;

import cn.hutool.core.util.ReUtil;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/4/20 22:27
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        /*
        * 随机点名器1(学生独立完成)
        *
        * 需求:
        *       有一个文件里面存储了班级同学的信息, 每一个信息占一行
        *       格式为: 张三-男-23
        *       要求通过程序实现随机点名器
        *
        * 运行效果:
        *       第一次运行程序: 随即同学姓名1(只显示名字)
        *       第二次运行程序: 随即同学姓名2(只显示名字)
        *       第三次运行程序: 随即同学姓名3(只显示名字)
        *       ...
        * */

        File file = new File("E:\\Git\\demo1\\JianZJ\\myio\\src\\resource\\names.txt");

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        StringBuilder sb = new StringBuilder();
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        isr.close();
        System.out.println(sb);

        List<String> all = ReUtil.findAll("(...)-.-([0-9]{2})", sb, 1);
        System.out.println(all);

        Map<String, Boolean> mp = new HashMap<>();

        for (int i = 1; i <= 20; i++) {
            while (mp.containsKey(all.get(0))) {
                Collections.shuffle(all);
            }
            System.out.println("no." + i + " : " + all.get(0));
            mp.put(all.get(0), true);
        }

    }
}
