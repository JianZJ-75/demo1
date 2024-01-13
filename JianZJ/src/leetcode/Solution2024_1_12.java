package leetcode;

import java.util.HashMap;

/**
 * @Author: JianZJ
 * @Date: 2024/1/12 16:34
 */
public class Solution2024_1_12 {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> s1 = new HashMap<>();
        HashMap<String, Integer> s2 = new HashMap<>();
        for (String i : words1)
            s1.put(i, s1.getOrDefault(i, 0) + 1);
        for (String i : words2)
            s2.put(i, s2.getOrDefault(i, 0) + 1);
        int ans = 0;
        for (String i : s1.keySet())
            if (s1.get(i) == 1 && s2.getOrDefault(i, 0) == 1)
                ans++;
        return ans;
    }
}