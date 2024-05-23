package May_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/5/23 18:18
 */
public class Solution_2024_5_23 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        List<Integer>[] posList = new List[n + 1];
        Arrays.setAll(posList, i -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            posList[nums.get(i)].add(i);
        }
        int ans = 0;
        for (List<Integer> pos : posList) {
            if (pos.size() <= ans) {
                continue;
            }
            int l = 0, r = 0;
            for (; r < pos.size(); r++) {
                while (pos.get(r) - pos.get(l) - (r - l) > k) {
                    l++;
                }
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }
}
