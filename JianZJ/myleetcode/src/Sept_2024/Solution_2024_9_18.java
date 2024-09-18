package Sept_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/9/18 19:58
 */
public class Solution_2024_9_18 {
    // TODO
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        // 模拟乘客上车
        int j = 0;
        int c = 0;
        for (int t : buses) {
            for (c = capacity; c > 0 && j < passengers.length && passengers[j] <= t; c--) {
                j++;
            }
        }

        // 寻找插队时机
        j--;
        int ans = c > 0 ? buses[buses.length - 1] : passengers[j];
        while (j >= 0 && ans == passengers[j]) {
            ans--; // 往前找没人到达的时刻
            j--;
        }
        return ans;
    }
}