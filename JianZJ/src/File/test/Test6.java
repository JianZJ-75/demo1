package File.test;

import point.Point;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/4/5 0:29
 */
public class Test6 {

    private static Map<String, List<File>> mp = new HashMap<>();

    public static void main(String[] args) {
        /*
        * 需求:
        *       统计一个文件夹中每种文件的个数并打印 (考虑子文件夹)
        *       答应格式如下:
        *       txt: 3个
        *       doc: 4个
        *       jpg: 5个
        * */

        File src = new File("C:\\Users\\22798\\Desktop");

        count(src);

        for (var i : mp.keySet()) {
            System.out.println(i + ": " + mp.get(i).size() + "个");
            System.out.println(mp.get(i));
        }

    }

    public static void count(File src) {
        File[] files = src.listFiles();
        for (var file : files) {
            if (file.isFile()) {
                // .在正则表达式中表示匹配任意字符, 所有应写 //.
                String[] strings = file.getName().split("\\.");
                if (strings.length >= 2)
                    mp.computeIfAbsent(strings[strings.length - 1], i -> new ArrayList<>()).add(file);
            } else
                count(file);
        }
    }
}
