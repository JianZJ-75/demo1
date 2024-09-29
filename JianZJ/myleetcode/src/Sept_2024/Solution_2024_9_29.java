package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/29 19:12
 */
public class Solution_2024_9_29 {
    // TODO
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        int tk = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            ans += Math.min(tickets[i], (i <= k ? tk : tk - 1));
        }
        return ans;
    }
}