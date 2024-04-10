package test;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

/**
 * @Author JianZJ
 * @Date 2024/4/10 20:47
 */
public class Test06Case02 {
    public static void main(String[] args) throws IOException {
        /*
        * 需求:
        *       把文本顺序进行恢复到一个新文件中
        * */

        // 1. 读取数据
        BufferedReader br = new BufferedReader(new FileReader("myio\\src\\resource\\b.txt"));
        String str;
        TreeMap<Integer, String> tm = new TreeMap<>();
        while((str = br.readLine()) != null) {
            String[] arr = str.split("\\.");
            // 0: 序号    1: 内容
            tm.put(Integer.parseInt(arr[0]), str);
        }
        br.close();

        // 2. 写出数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("myio\\src\\resource\\h.txt"));
        Set<Map.Entry<Integer, String>> entries = tm.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            String value = entry.getValue();
            bw.write(value);
            bw.newLine();
        }
        // stream写法
//        tm.entrySet()
//                .stream()
//                .forEach(new Consumer<Map.Entry<Integer, String>>() {
//                    @Override
//                    public void accept(Map.Entry<Integer, String> integerStringEntry) {
//                        try {
//                            bw.write(integerStringEntry.getValue());
//                            bw.newLine();
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                });
        bw.close();

    }
}
