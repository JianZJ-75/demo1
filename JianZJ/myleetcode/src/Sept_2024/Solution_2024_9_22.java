package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/22 20:51
 */
public class Solution_2024_9_22 {
    // TODO
    public int findJudge(int n, int[][] trust) {
        int[] cnt1 = new int[n + 1];
        int[] cnt2 = new int[n + 1];
        for (var t : trust) {
            int a = t[0], b = t[1];
            ++cnt1[a];
            ++cnt2[b];
        }
        for (int i = 1; i <= n; ++i) {
            if (cnt1[i] == 0 && cnt2[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}