package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/24 22:58
 */
public class Solution_2024_5_24 {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int now = nums[i];
            while (len > 0 && now < ans[len - 1] && len + n - i > k) {
                len--;
            }
            if (len < k)
                ans[len++] = now;
        }
        return ans;
    }
}
