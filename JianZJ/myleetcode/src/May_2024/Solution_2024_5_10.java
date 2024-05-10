package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/10 21:01
 */
public class Solution_2024_5_10 {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        int n = batteryPercentages.length;
        int now = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] - now > 0) {
                ans++;
                now++;
            }
        }
        return ans;
    }
}
