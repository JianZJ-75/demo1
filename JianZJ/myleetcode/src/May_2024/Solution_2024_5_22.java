package May_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/5/22 10:41
 */
public class Solution_2024_5_22 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] i : matches) {
            int win = i[0];
            int loser = i[1];
            map.putIfAbsent(win, 0);
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == 0) {
                ans1.add(i);
            } else if (map.get(i) == 1) {
                ans2.add(i);
            }
        }
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
}
