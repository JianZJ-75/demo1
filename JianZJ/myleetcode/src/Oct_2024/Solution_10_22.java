package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/22 18:26
 */
public class Solution_10_22 {
    public int countCompleteDayPairs(int[] hours) {
        int[] pos = new int[24];
        int ans = 0;
        for (int i = hours.length - 1; i >= 0; i--) {
            int t = hours[i] % 24;
            ans += pos[(24 - t) % 24];
            pos[t]++;
        }
        return ans;
    }
}