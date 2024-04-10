package Mar_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/3/6 16:51
 */
public class Solution_2024_3_6 {
    public int findKOr(int[] nums, int k) {
        int res = 0;
        int[] l = new int[32];
        for (var i : nums) {
            for (int j = 31; j >= 0; j--) {
                int x = i >> j & 1;
                if (x == 1)
                    l[j]++;
            }
        }
        for (int i = 0; i <= 31; i++) {
            if (l[i] >= k)
                res += qmi(2, i);
        }
        return res;
    }

    public int qmi(int a, int b) {
        int res = 1;
        while (b != 0) {
            if ((b & 1) == 1)
                res *= a;
            b /= 2;
            a *= a;
        }
        return res;
    }
}
