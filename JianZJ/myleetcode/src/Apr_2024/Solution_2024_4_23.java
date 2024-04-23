package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/23 16:37
 */
public class Solution_2024_4_23 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (i < minutes || grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        int ans = sum;
        int l = 0, r = minutes;
        for (; r < customers.length; r++) {
            if (grumpy[r] == 1) {
                sum += customers[r];
            }
            if (grumpy[l] == 1) {
                sum -= customers[l];
            }
            l++;
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
