package iotest.test4;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author JianZJ
 * @Date 2024/4/23 21:57
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        /*
        * Properties跟IO流结合的操作
        * */

        // 1. 创建集合的对象
        Properties prop = new Properties();

        // 2. 添加数据
        prop.put("aaa", "111");
        prop.put("bbb", "222");
        prop.put("ccc", "333");
        prop.put("ddd", "444");

        // 3. 把集合中的数据以键值对的形式写到本地文件当中
        FileOutputStream fos = new FileOutputStream(new File("myio\\src\\resource\\a.properties"));
        // 参数一在外面定义是为了方便关流, 参数二是注释
        prop.store(fos, "test");
        fos.close();
//        BufferedWriter bw = new BufferedWriter(new FileWriter("myio\\src\\resource\\a.properties"));
//        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
//        for (Map.Entry<Object, Object> entry : entries) {
//            Object key = entry.getKey();
//            Object value = entry.getValue();
//            bw.write(key + "=" + value);
//            bw.newLine();
//        }
//        bw.close();

    }
}
