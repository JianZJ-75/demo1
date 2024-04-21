package iotest.test1;

import cn.hutool.core.util.ReUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author JianZJ
 * @Date 2024/4/20 22:57
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        /*
         * 随机点名器2(学生独立完成)
         *
         * 需求:
         *      有一个文件里面存储了班级同学的信息, 每一个信息占一行
         *      格式为: 张三-男-23
         *      要求通过程序实现随机点名器
         *
         * 运行效果:
         *      70%的概率随机到男生
         *      30%的概率随机到女生
         *      总共随机100万次, 统计结果
         *      注意观察: 看生成男生和女生比例是不是接近于7 : 3
         * */

        File file = new File("myio\\src\\resource\\names.txt");

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();

        List<String> all = ReUtil.findAll("...-.-[0-9]{2}", sb, 0);
        List<String> boyNameList = all.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());
        List<String> girlNameList = all.stream()
                .filter(s -> "女".equals(s.split("-")[1]))
                .collect(Collectors.toList());

        List<String> names = new ArrayList<>();
        int cnt = 1000000;
        int boyCnt = 0, girlCnt = 0;
        while (cnt-- != 0) {
            Random r = new Random();
            if (r.nextInt(10) + 1 <= 7) {
                Collections.shuffle(boyNameList);
                names.add(boyNameList.get(0));
                boyCnt++;
            } else {
                Collections.shuffle(girlNameList);
                names.add(girlNameList.get(0));
                girlCnt++;
            }
        }

        System.out.println(names);
        System.out.println("boyCnt:" + boyCnt);
        System.out.println("girlCnt:" + girlCnt);
        System.out.println(1.0 * boyCnt / (boyCnt + girlCnt));
    }
}
