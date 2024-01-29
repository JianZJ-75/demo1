package leetcode.Jan_2024;

import java.util.*;

/**
 * @Author: JianZJ
 * @Date: 2024/1/24 11:56
 */
public class Solution_2024_1_24 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long res = 0;
        int n = maxHeights.size();
        int[] mx = maxHeights.stream().mapToInt(i -> i).toArray();
        long[] pre = new long[n];
        long[] last = new long[n];
        Deque<Integer> stk = new ArrayDeque<>();
        long sum = 0;
        stk.push(-1);
        for (int i = 0; i < n; i++) {
            while (stk.size() > 1 && mx[stk.peek()] >= mx[i]) {
                int j = stk.pop();
                sum -= (long) mx[j] * (j - stk.peek());
            }
            sum += (long) mx[i] * (i - stk.peek());
            pre[i] = sum;
            stk.push(i);
        }
        sum = 0;
        stk.clear();
        stk.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 1 && mx[stk.peek()] >= mx[i]) {
                int j = stk.pop();
                sum -= (long) mx[j] * (stk.peek() - j);
            }
            sum += (long) mx[i] * (stk.peek() - i);
            last[i] = sum;
            stk.push(i);
        }
        for (int i = 0; i < n; i++)
            res = Math.max(res, pre[i] + last[i] - mx[i]);
        return res;
    }
}
