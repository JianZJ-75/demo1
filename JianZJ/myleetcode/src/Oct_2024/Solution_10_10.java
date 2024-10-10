package Oct_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/10/10 18:51
 */
public class Solution_10_10 {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            if (x % k != 0) {
                continue;
            }
            x /= k;
            for (int i = 1; i * i <= x; i++) {
                if (x % i == 0) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    if (i != x / i) {
                        map.put(x / i, map.getOrDefault(x / i, 0) + 1);
                    }
                }
            }
        }
        int ans = 0;
        for (int x : nums2) {
            ans += map.getOrDefault(x, 0);
        }
        return ans;
    }
}