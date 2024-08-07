package problems;

/**
 * @Author JianZJ
 * @Date 2024/8/7 14:30
 */
public class Solution_940 {

    private static final int MOD = 1000000007;

    public int distinctSubseqII(String s) {
        long f[] = new long[26];
        long ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            long tmp = ans - f[c];
            f[c] = 1 + ans;
            ans = (((f[c] + tmp) % MOD) + MOD) % MOD;
        }
        return (int) ans;
    }
}