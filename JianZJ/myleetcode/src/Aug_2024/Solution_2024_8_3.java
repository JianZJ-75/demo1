package Aug_2024;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/8/3 18:05
 */
public class Solution_2024_8_3 {
    public int maxPointsInsideSquare(int[][] points, String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        TreeMap<Integer, Integer> ans = new TreeMap<>();
        int r = (int) 1e9 + 1;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            Character t = s.charAt(i);
            Integer v = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            ans.put(v, ans.getOrDefault(v, 0) + 1);
            if (!map.containsKey(t)) {
                map.put(t, new ArrayList<>());
            }
            map.get(t).add(v);
        }
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1)
                continue;
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            r = Math.min(r, list.get(1));
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
            if (entry.getKey() >= r)
                break;
            sum += entry.getValue();
        }
        return sum;
    }
}