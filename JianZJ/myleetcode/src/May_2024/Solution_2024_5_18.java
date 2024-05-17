package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/18 2:03
 */
public class Solution_2024_5_18 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = divisors[0];
        int mx = -1;
        for (int i : divisors) {
            int cnt = 0;
            for (int j : nums) {
                if (j % i == 0) {
                    cnt++;
                }
            }
            if (cnt > mx) {
                mx = cnt;
                ans = i;
            } else if (cnt == mx) {
                ans = Math.min(ans, i);
            }
        }
        return ans;
    }
}
