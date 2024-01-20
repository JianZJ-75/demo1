import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: JianZJ
 * @Date: 2024/1/9 15:37
 */

public class Main {
    public long minimumCost(int[] nums, int k, int dist) {
        PriorityQueue<Long> q = new PriorityQueue<Long>();
        int n = nums.length;
        int l = 2;
        long ans = (long)1e14;
        long sum = (long)nums[0] + (long)nums[l + dist];
        Arrays.sort(nums, l, l + dist);
        for (int i = l; i < l + dist; i++)
            q.offer((long) nums[i]);
        for (int i = 1; i <= k - 2; i++) {
            sum += q.peek();
            q.poll();
        }
        for (int i = l + dist + 1; i < n; i++) {
            sum -= (long)nums[i - 1] + (long)nums[l];
            q.offer((long) nums[i - 1]);

            l++;
            ans = Math.min(ans, sum);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}