import java.io.*;
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

    static final int K = 828;

    public static void main(String[] args) throws IOException {

        List<Object[]> tabledatas = new ArrayList<>();
        tabledatas.add(new Object[]{"编号1", "标题1", "正文1"});

        //定义表格组件
        //并给表格设置标题和内容
        Object[][] o = tabledatas.stream().toArray(value -> new Object[value][]);
        for (Object[] objects : o) {
            System.out.println(Arrays.toString(objects));
        }
    }
}