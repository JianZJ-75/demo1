package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/16 18:26
 */
public class Solution_2024_5_16 {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        int mx = 0;
        for (int m : milestones) {
            sum += m;
            mx = Math.max(mx, m);
        }
        return mx > sum - mx + 1 ? 2 * (sum - mx) + 1 : sum;
    }
}
