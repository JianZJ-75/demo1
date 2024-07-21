package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/21 1:23
 */
public class Solution_2024_7_21 {
    public int maximumSum(int[] arr) {
        int ans = Integer.MIN_VALUE / 2;
        int f0 = ans;
        int f1 = ans;
        int n = arr.length;
        for (int x : arr) {
            // 只删一个
            f1 = Math.max(f0, f1 + x);
            // 一个都不删
            f0 = Math.max(f0, 0) + x;
            ans = Math.max(ans, Math.max(f0, f1));
        }
        return ans;
    }
}