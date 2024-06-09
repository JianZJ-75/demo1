package Jun_2024;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author JianZJ
 * @Date 2024/6/9 15:38
 */
public class Solution_2024_6_9 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 1; i <= n; i++)
            arr[i] = nums[i - 1];
        int[][] f = new int[n + 2][n + 2];
        for (int i = n + 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return f[0][n + 1];
    }
}