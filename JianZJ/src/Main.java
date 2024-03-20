import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: JianZJ
 * @Date: 2024/1/9 15:37
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-男-15", "周芷若-女-14", "赵敏-女-13", "张强-男-20", "张三丰-男-100", "张翠山-男-40", "张良-男-35", "王二麻子-男-37", "谢广坤-男-41");

        // collect(Collector collector) 收集流中的数据，放到集合中(List Set Map)
        // 注意：
        //      如果我们要收集到Map集合当中，键不能重复，否则会报错

        // 收集到List集合当中
        // 需求：
        // 我要把所有的男性收集起来
        List<String> list1 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());
        System.out.println(list1);

        // 收集到Set集合当中
        // 需求：
        // 我要把所有的男性收集起来
        Set<String> set = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println(set);

        // 收集到Map集合当中
        // 谁作为键，谁作为值
        // 需求：
        // 我要把所有的男性收集起来
        // 键：姓名 值：年龄

        // 张无忌-男-15
        Map<String, Integer> map = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                /*
                 *       toMap : 参数一表示键的生成规则
                 *               参数二表示值的生成规则
                 *
                 *   参数一：
                 *       Function泛型一：表示流中每一个数据的类型
                 *               泛型二：表示Map集合中的数据类型
                 *       方法apply形参：依次表示流里面每一个数据的类型
                 *               方法体：生成键的代码
                 *               返回值：已经生成的键
                 *
                 *   参数二：
                 *       Function泛型一：表示流中每一个数据的类型
                 *               泛型二：表示Map集合中的数据类型
                 *       方法apply形参：依次表示流里面每一个数据的类型
                 *               方法体：生成值的代码
                 *               返回值：已经生成的值
                 *
                 * */
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split("-")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);
                    }
                }));
        map.entrySet().stream().forEach(s -> System.out.println(s));

        Map<String, Integer> map1 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[2])));
        map.entrySet().stream().forEach(s -> System.out.println(s));
    }
}