package Aug_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/8/16 17:40
 */
public class Solution_2024_8_16 {

    private Map<Long, Integer> memo = new HashMap<>();
    private int[] nums;
    private int[] andValues;

    public int minimumValueSum(int[] nums, int[] andValues) {
        this.nums = nums;
        this.andValues = andValues;
        int ans = dfs(0, 0, -1);
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    private int dfs(int i, int j, int and) {
        int n = nums.length;
        int m = andValues.length;
        // 当前剩余的不够分组
        if (n - i < m - j) {
            return Integer.MAX_VALUE / 2;
        }
        if (j == m)
        {
            return i == n ? 0 : Integer.MAX_VALUE / 2;
        }
        and &= nums[i];
        // 压缩状态, 记忆化
        Long key = (long) i << 30 | (long) j << 20 | and;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = dfs(i + 1, j, and);
        if (and == andValues[j]) {
            res = Math.min(res, dfs(i + 1, j + 1, -1) + nums[i]);
        }
        memo.put(key, res);
        return res;
    }
}