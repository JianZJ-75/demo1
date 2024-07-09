package July_2024;

import java.util.TreeMap;

/**
 * @Author JianZJ
 * @Date 2024/7/8 18:38
 */
public class Solution_2024_7_9 {
    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> xs = new TreeMap<>();
        TreeMap<Integer, Integer> ys = new TreeMap<>();
        int ans = Integer.MAX_VALUE;
        for (int[] point : points) {
            int x = point[0] + point[1];
            int y = point[1] - point[0];
            xs.put(x, xs.getOrDefault(x, 0) + 1);
            ys.put(y, ys.getOrDefault(y, 0) + 1);
        }
        for (int[] point : points) {
            int x = point[0] + point[1];
            int y = point[1] - point[0];

            if (xs.get(x) == 1)
                xs.remove(x);
            else
                xs.put(x, xs.getOrDefault(x, 0) - 1);
            if (ys.get(y) == 1)
                ys.remove(y);
            else
                ys.put(y, ys.getOrDefault(y, 0) - 1);

            int xx = xs.lastKey() - xs.firstKey();
            int yy = ys.lastKey() - ys.firstKey();
            ans = Math.min(ans, Math.max(xx, yy));

            xs.put(x, xs.getOrDefault(x, 0) + 1);
            ys.put(y, ys.getOrDefault(y, 0) + 1);
        }
        return ans;
    }
}