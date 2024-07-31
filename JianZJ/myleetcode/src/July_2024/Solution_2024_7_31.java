package July_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/7/31 13:09
 */
public class Solution_2024_7_31 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int ans = 0;
        int x = -1;
        for (int[] point : points) {
            if (point[0] > x) {
                ans++;
                x = point[0] + w;
            }
        }
        return ans;
    }
}