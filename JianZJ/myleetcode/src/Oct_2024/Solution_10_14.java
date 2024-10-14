package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/14 21:58
 */
public class Solution_10_14 {
    // TODO
    public int superEggDrop(int k, int n) {
        int[][] memo = new int[n + 1][];
        for (int i = 1; ; i++) {
            memo[i] = new int[k + 1]; // 动态创建 memo
            if (dfs(i, k, memo) >= n) {
                return i;
            }
        }
    }

    private int dfs(int i, int j, int[][] memo) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (memo[i][j] != 0) { // 之前计算过
            return memo[i][j];
        }
        return memo[i][j] = dfs(i - 1, j, memo) + dfs(i - 1, j - 1, memo) + 1;
    }
}