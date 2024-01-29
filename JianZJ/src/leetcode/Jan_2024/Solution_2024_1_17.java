package leetcode.Jan_2024;

/**
 * @Author: JianZJ
 * @Date: 2024/1/17 21:01
 */
public class Solution_2024_1_17 {
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0))
                    ans++;
        return ans;
    }
}
