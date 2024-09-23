package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/23 23:04
 */
public class Solution_2024_9_23 {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0;
        int mx = values[0];
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, mx + values[i] - i);
            mx = Math.max(mx, values[i] + i);
        }
        return ans;
    }
}