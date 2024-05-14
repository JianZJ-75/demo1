package May_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/5/14 18:08
 */
public class Solution_2024_5_14 {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int n = tasks.length;
        int ans = 0;
        for (int i = 0; i < n;) {
            int j = i;
            int len = 0;
            while (j < n && tasks[i] == tasks[j]) {
                j++;
                len++;
            }
            if (len < 2) {
                return -1;
            }
            if (len % 3 >= 1) {
                ans += len / 3 + 1;
            } else {
                ans += len / 3;
            }
            i = j;
        }
        return ans;
    }
}
