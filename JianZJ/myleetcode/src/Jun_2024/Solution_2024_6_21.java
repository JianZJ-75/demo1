package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/21 18:00
 */
public class Solution_2024_6_21 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int n = temperatureA.length;
        int ans = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 1; i < n; i++) {
            a[i] = temperatureA[i] - temperatureA[i - 1];
            b[i] = temperatureB[i] - temperatureB[i - 1];
            a[i] = a[i] >= 0 ? a[i] > 0 ? 1 : 0 : -1;
            b[i] = b[i] >= 0 ? b[i] > 0 ? 1 : 0 : -1;
        }
        for (int i = 1; i < n;) {
            if (a[i] != b[i]) {
                i++;
                continue;
            }
            int j = i;
            int len = 0;
            while (j < n && a[j] == b[j]) {
                j++;
                len++;
            }
            ans = Math.max(ans, len);
            i = j;
        }
        return ans;
    }
}