package leetcode.Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/8 15:25
 */
public class Solution_2024_3_9 {
    static final int MOD = 1_000_000_007;
    public int minimumPossibleSum(int n, int target) {
        long m = Math.min(n, target / 2);
//        注意下 ！一定要把target*2放在(n-m-1)的后面 否则当target*2和n特别大时可能会超出限制～
        return (int) (((m + 1) * m + (n - m - 1 + target + target) * (n - m)) / 2 % MOD);
    }
}