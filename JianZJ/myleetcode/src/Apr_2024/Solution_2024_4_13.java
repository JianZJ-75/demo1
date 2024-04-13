package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/13 21:44
 */
public class Solution_2024_4_13 {
    public int findChampion(int n, int[][] edges) {
        boolean[] weak = new boolean[n];
        for (var i : edges) {
            weak[i[1]] = true;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (!weak[i]) {
                if (ans != -1)
                {
                    return -1;
                }
                ans = i;
            }
        }
        return ans;
    }
}
