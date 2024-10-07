package Oct_2024;

import java.util.PriorityQueue;

/**
 * @Author JianZJ
 * @Date 2024/10/7 20:14
 */
public class Solution_10_7 {
    // TODO
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int ans = 0;
        int prePosition = 0;
        int curFuel = startFuel;
        PriorityQueue<Integer> fuelHeap = new PriorityQueue<>((a, b) -> b - a); // 最大堆
        for (int i = 0; i <= n; i++) {
            int position = i < n ? stations[i][0] : target;
            curFuel -= position - prePosition; // 每行驶 1 英里用掉 1 升汽油
            while (!fuelHeap.isEmpty() && curFuel < 0) { // 没油了
                curFuel += fuelHeap.poll(); // 选油量最多的油桶
                ans++;
            }
            if (curFuel < 0) { // 无法到达
                return -1;
            }
            fuelHeap.offer(i < n ? stations[i][1] : 0); // 留着后面加油
            prePosition = position;
        }
        return ans;
    }
}