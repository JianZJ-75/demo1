package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/27 23:42
 */
public class Solution_2024_5_27 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int rem = mean * (n + rolls.length);
        for (int roll : rolls) {
            rem -= roll;
        }
        if (rem < n || rem > n * 6) {
            return new int[]{};
        }

        int avg = rem / n;
        int extra = rem % n;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = avg + (i < extra ? 1 : 0);
        }
        return ans;
    }
}
