package Jun_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/6/25 19:02
 */
public class Solution_2024_6_25 {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < m; j++) {
                tmp += grid[i][j] << (m - 1 - j);
            }
            if (tmp == 0)
                return List.of(i);
            map.put(tmp, i);
        }
        for (Integer i : map.keySet()) {
            for (Integer j : map.keySet()) {
                if ((i & j) == 0) {
                    int l = Math.min(map.get(i), map.get(j));
                    int r = Math.max(map.get(i), map.get(j));
                    return List.of(l, r);
                }
            }
        }
        return List.of();
    }
}