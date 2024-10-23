package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/23 22:00
 */
public class Solution_10_23 {
    public long countCompleteDayPairs(int[] hours) {
        int[] pos = new int[24];
        long ans = 0;
        for (int i = hours.length - 1; i >= 0; i--) {
            int t = hours[i] % 24;
            ans += pos[(24 - t) % 24];
            pos[t]++;
        }
        return ans;
    }
}