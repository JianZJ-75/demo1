package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/21 23:20
 */
public class Solution_2024_5_19 {
    public int getWinner(int[] arr, int k) {
        int ans = arr[0];
        int win = 0;
        int n = arr.length;
        for (int i = 1; i < n && win < k; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
                win = 0;
            }
            win++;
        }
        return ans;
    }
}
