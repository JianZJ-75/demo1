package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/27 15:57
 */
public class Solution_2024_7_27 {
    public String getSmallestString(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (k == tmp) {
                ans.append(c);
                continue;
            }
            int min = Math.min(c - 'a', 'a' + 26 - c);
            if (tmp + min <= k) {
                ans.append('a');
                tmp += min;
            } else {
                int sy = k - tmp;
                char c1 = (char) ('a' + (c - 'a' - sy + 26) % 26);
                char c2 = (char) ('a' + (c - 'a' + sy) % 26);
                ans.append(c1 < c2 ? c1 : c2);
                tmp = k;
            }
        }
        return ans.toString();
    }
}