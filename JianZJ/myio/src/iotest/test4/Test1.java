package iotest.test4;

import java.util.Map;
import java.util.Properties;

/**
 * @Author JianZJ
 * @Date 2024/4/23 21:47
 */
public class Test1 {
    public static void main(String[] args) {
        /*
        * Properties作为Map集合的操作
        * */

        // 1. 创建集合的对象
        Properties prop = new Properties();

        // 2. 添加数据
        // 细节: 虽然我们可以往Properties当中添加仁义的数据类型, 但是一般只会往里面添加字符串类型的数据
        prop.put("aaa", "111");
        prop.put("bbb", "222");
        prop.put("ccc", "333");
        prop.put("ddd", "444");

        // 3. 遍历集合
        for (Object o : prop.keySet()) {
            System.out.println(prop.get(o));
        }

        for (Map.Entry<Object, Object> o : prop.entrySet()) {
            Object key = o.getKey();
            Object value = o.getValue();
            System.out.println(key + "=" + value);
        }

    }
}
