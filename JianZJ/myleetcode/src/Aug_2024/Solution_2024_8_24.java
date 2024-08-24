package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/24 22:25
 */
public class Solution_2024_8_24 {
    public int findPermutationDifference(String s, String t) {
        int a[] = new int[26];
        int b[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < t.length(); i++) {
            b[t.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(a[i] - b[i]);
        }
        return ans;
    }
}