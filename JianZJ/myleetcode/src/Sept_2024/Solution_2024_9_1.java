package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/1 0:59
 */
public class Solution_2024_9_1 {
    public int busyStudent(int[] st, int[] et, int t) {
        int n = st.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (st[i] <= t && et[i] >= t) {
                ans++;
            }
        }
        return ans;
    }
}