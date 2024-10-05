package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/5 18:51
 */
public class Solution_10_5 {

    static int totalTrips;
    static int[] time;

    public long minimumTime(int[] time, int totalTrips) {
        this.totalTrips = totalTrips;
        this.time = time;
        long l = 0, r = (long) 1e14 + 1;
        while (r - l > 1) {
            long mid = (l + r) / 2;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }

    private boolean check(long mid) {
        long cnt = 0;
        for (int i = 0; i < time.length; i++) {
            cnt += mid / time[i];
        }
        return cnt >= totalTrips;
    }

}