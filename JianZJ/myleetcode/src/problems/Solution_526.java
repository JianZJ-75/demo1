package problems;

/**
 * @Author JianZJ
 * @Date 2024/6/26 14:28
 */
public class Solution_526 {
    public int countArrangement(int n) {
        int[] f = new int[1 << n];
        f[0] = 1;
        for (int s = 1; s < (1 << n); s++) {
            int i = Integer.bitCount(s);
            for (int j = 1; j <= n; j++) {
                if (((s >> (j - 1)) & 1) == 1 && (i % j == 0 || j % i == 0))
                    f[s] += f[s ^ (1 << (j - 1))];
            }
        }
        return f[(1 << n) - 1];
    }
}