package demo.hutool;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/17 20:48
 */
public class Test1 {
    public static void main(String[] args) {
        /*
        FileUtil类:
                file：根据参数创建一个file对象
                touch：根据参数创建文件

                writeLines：把集合中的数据写出到文件中，覆盖模式。
                appendLines：把集合中的数据写出到文件中，续写模式。
                readLines：指定字符编码，把文件中的数据，读到集合中。
                readUtf8Lines：按照UTF-8的形式，把文件中的数据，读到集合中

                copy：拷贝文件或者文件夹
        */

        File file = FileUtil.file("E:\\", "Git", "demo1", "JianZJ\\myio\\src\\resource\\a.txt");
        System.out.println(file);

        // 就算父级路径不存在, 也能创建
        File touch = FileUtil.touch("E:\\Git\\demo1\\JianZJ\\myio\\src\\resource\\abc\\a\\a.txt");
        System.out.println(touch);

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "avda", "dadsada\n", "hccsb");
        System.out.println(list);
        FileUtil.writeLines(list, file, "UTF-8");

        FileUtil.appendLines(list, file, "UTF-8");

        // 每一行认为是集合里面的一个元素
        List<String> strings = FileUtil.readLines(file, "UTF-8");
        System.out.println(strings);

    }
}
