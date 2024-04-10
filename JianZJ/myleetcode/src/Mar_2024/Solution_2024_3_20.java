package Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/20 18:37
 */

public class Solution_2024_3_20 {
    private static final int MOD = 1_000_000_007;

    public long qmi(long a, long b) {
        a %= MOD; // 错误点
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % MOD;
            a = a * a % MOD;
            b /= 2;
        }
        return res;
    }

    public int minNonZeroProduct(int p) {
        long mx = (1L << p) - 1;
        return (int) (mx % MOD * qmi(mx - 1, mx / 2) % MOD);
    }
}
