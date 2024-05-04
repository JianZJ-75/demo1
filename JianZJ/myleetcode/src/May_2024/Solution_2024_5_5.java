package May_2024;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author JianZJ
 * @Date 2024/5/5 1:15
 */
public class Solution_2024_5_5 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            int[] ans = new int[n];
            Arrays.fill(ans, 0);
            return ans;
        }
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + code[i];
        }
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int now = 0;
                now += pre[Math.min(n, i + 1 + k)] - pre[i + 1];
                now += pre[Math.max(0, k - (n - 1 - i))];
                code[i] = now;
            }
        } else {
            k *= -1;
            for (int i = 0; i < n; i++) {
                int now = 0;
                now += pre[i] - pre[Math.max(0, i - k)];
                now += pre[n] - pre[n - Math.max(0, (k - i))];
                code[i] = now;
            }
        }
        return code;
    }
}
