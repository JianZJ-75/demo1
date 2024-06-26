package Jun_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/6/26 14:25
 */
public class Solution_2024_6_26 {
    public int specialPerm(int[] nums) {
        int n = nums.length;
        int u = 1 << n;
        long[][] f = new long[u][n];
        Arrays.fill(f[0], 1L);
        for (int s = 1; s < u; s++) {
            for (int i = 0; i < n; i++) {
                if (((s >> i) & 1) == 1)
                    continue;
                for (int j = 0; j < n; j++) {
                    if (((s >> j) & 1) == 1 && (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0))
                        f[s][i] += f[s ^ (1 << j)][j];
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += f[(u - 1) ^ (1 << i)][i];
        }
        return (int) (ans % 1_000_000_007);
    }
}