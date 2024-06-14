package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/14 16:33
 */
public class Solution_2024_6_14 {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] f = new long[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            int j = nums[i] % 2;
            int v = nums[i];
            f[i][j] = Math.max(f[i + 1][j], f[i + 1][j ^ 1] - x) + v;
            f[i][j ^ 1] = f[i + 1][j ^ 1];
        }
        return f[0][nums[0] % 2];
    }
}