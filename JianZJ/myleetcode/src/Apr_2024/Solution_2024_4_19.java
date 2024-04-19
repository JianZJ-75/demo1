package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/19 20:41
 */
public class Solution_2024_4_19 {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int sum = 0;
        for (int i : dist) {
            sum += i;
        }
        if (sum > (long) hoursBefore * speed) {
            return -1;
        }
        int n = dist.length;
        int[] f = new int[n];
        for (int i = 0; ; i++) {
            int t = 0;
            for (int j = 0; j < n - 1; j++) {
                int temp = f[j + 1];
                f[j + 1] = (f[j] + dist[j] + speed - 1) / speed * speed;
                if (i > 0) {
                    f[j + 1] = Math.min(f[j + 1], t + dist[j]);
                }
                t = temp;
            }
            if (f[n - 1] + dist[n - 1] <= (long) hoursBefore * speed) {
                return i;
            }
        }
    }
}
