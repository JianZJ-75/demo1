package Jun_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/6/17 21:29
 */
public class Solution_2024_6_17 {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                if (pos(strs[i], strs[j])) {
                    ok = false;
                    break;
                }
            }
            if (ok)
                return strs[i].length();
        }
        return -1;
    }

    private boolean pos(String s, String t) {
        int idx = 0;
        for (int i = 0; i < t.length(); i++) {
            if (idx < s.length() && s.charAt(idx) == t.charAt(i))
                idx++;
        }
        if (idx == s.length())
            return true;
        return false;
    }
}