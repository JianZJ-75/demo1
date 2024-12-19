package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/12/13 23:38
 */
public class Solution_3 {

    private static Map<Character, Boolean> map;

    public int lengthOfLongestSubstring(String s) {
        map = new HashMap<>();
        int ans = 0, l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (map.getOrDefault(s.charAt(r), false) == false) {
                map.put(s.charAt(r), true);
            } else {
                while (s.charAt(l) != s.charAt(r)) {
                    map.put(s.charAt(l), false);
                    l++;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

}