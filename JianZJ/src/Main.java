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
        Map<Integer, Boolean> mp = new HashMap<>();
        mp.put(1, false);
        Boolean b = mp.get(1);
        b = true;
        System.out.println(mp.get(1));
    }

    public void init(int a)
    {
        sd ss = new sd(a);
        System.out.println(ss.a);
    }

    class sd
    {
        int a;
        public sd(int a) { this.a = a; }
    }
}