package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/10 20:47
 */
public class Test06Case01 {
    public static void main(String[] args) throws IOException {
        /*
        * 需求:
        *       把文本顺序进行恢复到一个新文件中
        * */

        // 1. 读取数据
        BufferedReader br = new BufferedReader(new FileReader("myio\\src\\resource\\b.txt"));
        String str;
        List<String> list = new ArrayList<>();
        while((str = br.readLine()) != null) {
            list.add(str);
        }
        br.close();

        // 2. 排序
        // 排序规则: 按照每一行前面的序号进行排列
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i1 = Integer.parseInt(o1.split("\\.")[0]);
                int i2 = Integer.parseInt(o2.split("\\.")[0]);
                return i1 - i2;
            }
        });

        // 3. 写出
        BufferedWriter bw = new BufferedWriter(new FileWriter("myio\\src\\resource\\g.txt"));
        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();

    }
}
