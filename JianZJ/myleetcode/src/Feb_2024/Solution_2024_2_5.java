package Feb_2024;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author 22798
 * @Date 2024/2/5 20:51
 */
public class Solution_2024_2_5 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        for (int i = 1; i < n; i++) {
            if (q.peekFirst() < i - k)
                q.pollFirst();
            nums[i] += nums[q.peekFirst()];
            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }
            q.add(i);
        }
        return nums[n - 1];
    }
}
