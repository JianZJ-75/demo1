package Sept_2024;

import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/9/15 20:40
 */
public class Solution_2024_9_15 {
    public int numberOfPoints(List<List<Integer>> nums) {
        int maxEnd = 0;
        for (List<Integer> p : nums) {
            maxEnd = Math.max(maxEnd, p.get(1));
        }

        int[] diff = new int[maxEnd + 2]; // 注意下面有 end+1
        for (List<Integer> interval : nums) {
            diff[interval.get(0)]++;
            diff[interval.get(1) + 1]--;
        }

        int ans = 0;
        int s = 0;
        for (int d : diff) {
            s += d;
            if (s > 0) {
                ans++;
            }
        }
        return ans;
    }
}