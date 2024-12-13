package Dec_2024;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author JianZJ
 * @Date 2024/12/13 11:04
 */
public class Solution_2024_12_13 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
                new Comparator<int[]>() {
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] == o2[0]) {
                            return o1[1] - o2[1];
                        }
                        return o1[0] - o2[0];
                    }
                }
        );
        for (int i = 0; i < nums.length; i++) {
            q.add(new int[]{nums[i], i});
        }
        for (int i = 0; i < k; i++) {
            int[] tmp = q.poll();
            tmp[0] *= multiplier;
            q.add(tmp);
        }
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            nums[tmp[1]] = tmp[0];
        }
        return nums;
    }

}