package leetcode.Feb_2024;

import java.util.PriorityQueue;

/**
 * @Author: JianZJ
 * @Date: 2024/2/1 12:37
 */
public class Solution_2024_2_1 {
    final int MOD = (int)1e9 + 7;
    public int[] numsGame(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();
        long l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            int b = nums[i] - i;
            if (i % 2 == 0) {
                left.offer(b);
                l += b;
                l -= left.peek();
                b = left.poll();
                r += b;
                right.offer(b);
                ans[i] = (int) ((r - l - right.peek()) % MOD);
            } else {
                right.offer(b);
                r += b;
                r -= right.peek();
                b = right.poll();
                l += b;
                left.offer(b);
                ans[i] = (int) ((r - l) % MOD);
            }
        }
        return ans;
    }
}