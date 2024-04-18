package Apr_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/4/18 10:55
 */
public class Solution_2024_4_18 {
    public int[] findOriginalArray(int[] changed) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (var i : changed) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        int cnt0 = mp.getOrDefault(0, 0);
        if (cnt0 % 2 != 0) {
            return new int[0];
        }
        mp.remove(0);
        int[] res = new int[changed.length / 2];
        int index = cnt0 / 2;
        for (var i : mp.keySet()) {
            if (i % 2 == 0 && mp.getOrDefault(i / 2, 0) != 0) {
                continue;
            }
            while (mp.containsKey(i)) {
                int cnt1 = mp.getOrDefault(i, 0);
                int cnt2 = mp.getOrDefault(i * 2, 0);
                if (cnt1 > cnt2) {
                    return new int[0];
                }
                for (int k = 1; k <= cnt1; k++) {
                    res[index++] = i;
                }
                if (cnt1 < cnt2) {
                    mp.put(i * 2, cnt2 - cnt1);
                    i *= 2;
                } else {
                    i *= 4;
                }
            }
        }
        return res;
    }
}
