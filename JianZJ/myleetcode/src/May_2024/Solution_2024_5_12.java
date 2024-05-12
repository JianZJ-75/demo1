package May_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/5/12 21:32
 */
public class Solution_2024_5_12 {
    private final Map<Integer, Integer> memo = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        Integer i = memo.get(n);
        if (i != null) {
            return i;
        }
        i = Math.min(minDays(n / 2) + n % 2, minDays(n / 3) + n % 3) + 1;
        memo.put(n, i);
        return i;
    }
}
