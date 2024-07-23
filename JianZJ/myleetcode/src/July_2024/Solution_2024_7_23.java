package July_2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/7/23 10:25
 */
public class Solution_2024_7_23 {

    private Map<Long, Integer> mp = new HashMap<>();
    private final int mod = 1000000007;
    private int[] nums;
    private int n;

    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        this.nums = nums;
        n = nums.length;
        return dfs(0, n, k, Integer.MAX_VALUE);
    }

    private int dfs(int i, int j, int k, int mi) {
        if (i == n)
            return k == 0 ? mi : 0;
        if (n - i < k)
            return 0;
        long key = 1L * mi << 18 | i << 12 | j << 6 | k;
        if (mp.containsKey(key))
            return mp.get(key);
        int ans = dfs(i + 1, j, k, mi);
        if (j == n)
            ans += dfs(i + 1, i, k - 1, mi);
        else
            ans += dfs(i + 1, i, k - 1, Math.min(mi, nums[i] - nums[j]));
        ans %= mod;
        mp.put(key, ans);
        return ans;
    }
}