package Aug_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/8/17 14:49
 */
public class Solution_2024_8_17 {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        int n = word.length();
        int mx = 0;
        for (int i = k; i <= n; i += k) {
            String tmp = word.substring(i - k, i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            mx = Math.max(mx, map.get(tmp));
        }
        return n / k - mx;
    }
}