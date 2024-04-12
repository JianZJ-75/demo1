package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/12 20:38
 */
public class Solution_2024_4_12 {
    public int findChampion(int[][] grid) {
        int ans = 0;
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][ans] == 1) {
                ans = i;
            }
        }
        return ans;
    }
}
