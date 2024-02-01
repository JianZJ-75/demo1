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

class Solution {
    public int[] numsGame(int[] nums) {
        final int MOD = 1_000_000_007;
        int[] ans = new int[nums.length];
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a); // 维护较小的一半，大根堆
        PriorityQueue<Integer> right = new PriorityQueue<>(); // 维护较大的一半，小根堆
        long leftSum = 0, rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int b = nums[i] - i;
            if (i % 2 == 0) { // 前缀长度是奇数
                if (!left.isEmpty() && b < left.peek()) {
                    leftSum -= left.peek() - b;
                    left.offer(b);
                    b = left.poll();
                }
                rightSum += b;
                right.offer(b);
                ans[i] = (int) ((rightSum - right.peek() - leftSum) % MOD);
            } else { // 前缀长度是偶数
                if (b > right.peek()) {
                    rightSum += b - right.peek();
                    right.offer(b);
                    b = right.poll();
                }
                leftSum += b;
                left.offer(b);
                ans[i] = (int) ((rightSum - leftSum) % MOD);
            }
        }
        return ans;
    }
}