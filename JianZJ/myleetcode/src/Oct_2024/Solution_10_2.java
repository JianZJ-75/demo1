package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/2 19:59
 */
public class Solution_10_2 {
    // TODO
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        long h100 = Math.round(hour * 100); // 下面不会用到任何浮点数
        long delta = h100 - (n - 1) * 100;
        if (delta <= 0) { // 无法到达终点
            return -1;
        }

        int maxDist = 0;
        for (int d : dist) {
            maxDist = Math.max(maxDist, d);
        }
        if (h100 <= n * 100) { // 特判
            // 见题解中的公式
            return Math.max(maxDist, (int) ((dist[n - 1] * 100 - 1) / delta + 1));
        }

        int left = 0;
        int h = (int) (h100 / (n * 100));
        int right = (maxDist - 1) / h + 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(mid, dist, h100)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int v, int[] dist, long h100) {
        int n = dist.length;
        long t = 0;
        for (int i = 0; i < n - 1; i++) {
            t += (dist[i] - 1) / v + 1;
        }
        return (t * v + dist[n - 1]) * 100 <= h100 * v;
    }
}