package Jan_2024;

import java.util.*;

/**
 * @Author: JianZJ
 * @Date: 2024/1/30 15:51
 */
public class Solution_2024_1_30 {
    public int minimumSeconds(List<Integer> nums) {
        int[] num = nums.stream().mapToInt(i -> i).toArray();
        int n = num.length;
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(num[i], j -> new ArrayList<>()).add(i);
        }
        int res = n;
        for (List<Integer> i : mp.values()) {
            int len = i.size();
            int t = (i.get(0) + n - i.get(len - 1)) / 2;
            for (int j = 1; j < len; j++) {
                t = Math.max(t, (i.get(j) - i.get(j - 1)) / 2);
            }
            res = Math.min(res, t);
        }
        return res;
    }
}
