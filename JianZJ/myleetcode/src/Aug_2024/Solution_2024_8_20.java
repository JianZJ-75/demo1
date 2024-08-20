package Aug_2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JianZJ
 * @Date 2024/8/20 23:29
 */
public class Solution_2024_8_20 {
    // TODO
    public int waysToReachStair(int k) {
        return dfs(1, 0, 0, k, new HashMap<>());
    }

    private int dfs(int i, int j, int preDown, int k, Map<Long, Integer> memo) {
        if (i > k + 1) { // 无法到达终点 k
            return 0;
        }
        // 把状态 (i, j, preDown) 压缩成一个 long
        long mask = (long) i << 32 | j << 1 | preDown;
        if (memo.containsKey(mask)) { // 之前算过了
            return memo.get(mask);
        }
        int res = i == k ? 1 : 0;
        res += dfs(i + (1 << j), j + 1, 0, k, memo); // 操作二
        if (preDown == 0 && i > 0) {
            res += dfs(i - 1, j, 1, k, memo); // 操作一
        }
        memo.put(mask, res); // 记忆化
        return res;
    }
}