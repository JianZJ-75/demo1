package Jun_2024;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author JianZJ
 * @Date 2024/6/24 14:42
 */
public class Solution_2024_6_24 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int x = nums[i % n];
            while (!q.isEmpty() && x >= q.peek())
                q.pop();
            if (i < n && !q.isEmpty())
                ans[i] = q.peek();
            q.push(x);
        }
        return ans;
    }
}