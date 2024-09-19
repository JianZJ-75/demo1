package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/19 22:36
 */
public class Solution_2024_9_19 {
    // TODO
    public int longestContinuousSubstring(String S) {
        char[] s = S.toCharArray();
        int ans = 1;
        int cnt = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i - 1] + 1 == s[i]) {
                ans = Math.max(ans, ++cnt);
            } else {
                cnt = 1;
            }
        }
        return ans;
    }
}