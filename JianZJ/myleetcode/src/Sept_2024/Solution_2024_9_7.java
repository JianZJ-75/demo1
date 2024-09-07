package Sept_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/9/7 21:51
 */
public class Solution_2024_9_7 {
    // TODO
    public int maximumLength(int[] nums, int k) {
        Map<Integer, int[]> fs = new HashMap<>();
        int[][] records = new int[k + 1][3];
        for (int x : nums) {
            int[] f = fs.computeIfAbsent(x, i -> new int[k + 1]);
            for (int j = k; j >= 0; j--) {
                f[j]++;
                if (j > 0) {
                    int mx = records[j - 1][0], mx2 = records[j - 1][1], num = records[j - 1][2];
                    f[j] = Math.max(f[j], (x != num ? mx : mx2) + 1);
                }

                // records[j] 维护 fs[.][j] 的 mx, mx2, num
                int v = f[j];
                int[] p = records[j];
                if (v > p[0]) {
                    if (x != p[2]) {
                        p[2] = x;
                        p[1] = p[0];
                    }
                    p[0] = v;
                } else if (x != p[2] && v > p[1]) {
                    p[1] = v;
                }
            }
        }
        return records[k][0];
    }
}