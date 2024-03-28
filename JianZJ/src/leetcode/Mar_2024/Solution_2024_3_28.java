package leetcode.Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/28 14:10
 */
public class Solution_2024_3_28 {
    static final long MOD = 1_000_000_007;
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long[] pre = new long[n];
        for (int i = 0; i < n - 1; i++) {
            int j = nextVisit[i];
            pre[i + 1] = (2 * pre[i] + pre[j] - 2 + MOD) % MOD;
        }
        return (int) pre[n - 1];
    }
}
