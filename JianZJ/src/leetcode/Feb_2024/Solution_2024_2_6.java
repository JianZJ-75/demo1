package leetcode.Feb_2024;

import java.util.PriorityQueue;

/**
 * @Author 22798
 * @Date 2024/2/6 21:14
 */
public class Solution_2024_2_6 {
    public int magicTower(int[] nums) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum <= 0)
            return -1;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int cnt = 0;
        long hp = 1;
        for (int i : nums) {
            hp += i;
            if (i < 0)
                q.offer(i);
            if (hp <= 0) {
                hp -= q.poll();
                cnt++;
            }
        }
        return cnt;
    }
}
