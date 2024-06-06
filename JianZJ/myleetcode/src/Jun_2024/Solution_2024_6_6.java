package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/6 8:33
 */
public class Solution_2024_6_6 {
    public long minimumSteps(String s) {
        long ans = 0;
        int n = s.length();
        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == '1')
                cnt++;
        for (int i = n - 1; i >= 0;) {
            int j = i;
            int len = 0;
            while (j >= 0 && s.charAt(j) == s.charAt(i)) {
                j--;
                len++;
            }
            if (j == -1) {
                break;
            }
            if (s.charAt(i) == '0')
                ans += 1l * cnt * len;
            else
                cnt -= len;
            i = j;
        }
        return ans;
    }
}
