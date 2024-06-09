package Jun_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/6/8 22:26
 */
public class Solution_2024_6_8 {

    private int[] nums;
    private int[][] memo;

    public int maxOperations(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        memo = new int[n][n];
        int res1 = calc(2, n - 1, nums[0] + nums[1]);
        int res2 = calc(0, n - 3, nums[n - 2] + nums[n - 1]);
        int res3 = calc(1, n - 2, nums[0] + nums[n - 1]);
        return max(res1, res2, res3) + 1;
    }

    private int max(int... tmp) {
        int res = 0;
        for (int i : tmp) {
            res = Math.max(res, i);
        }
        return res;
    }

    private int calc(int i, int j, int target) {
        for (int[] t : memo) {
            Arrays.fill(t, -1);
        }
        return dfs(i, j, target);
    }

    private int dfs(int i, int j, int target) {
        if (i >= j)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        int res = 0;
        if (nums[i] + nums[i + 1] == target)
            res = Math.max(res, dfs(i + 2, j, target) + 1);
        if (nums[j - 1] + nums[j] == target)
            res = Math.max(res, dfs(i, j - 2, target) + 1);
        if (nums[i] + nums[j] == target)
            res = Math.max(res, dfs(i + 1, j - 1, target) + 1);
        return memo[i][j] = res;
    }
}