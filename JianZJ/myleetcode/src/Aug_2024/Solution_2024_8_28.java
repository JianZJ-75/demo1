package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/28 23:39
 */
public class Solution_2024_8_28 {
    // TODO
    public int minimumSubstringsInPartition(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] memo = new int[n];
        return dfs(n - 1, s, memo);
    }

    private int dfs(int i, char[] s, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] > 0) { // 之前计算过
            return memo[i];
        }
        int res = Integer.MAX_VALUE;
        int[] cnt = new int[26];
        int k = 0, maxCnt = 0;
        for (int j = i; j >= 0; j--) {
            k += cnt[s[j] - 'a']++ == 0 ? 1 : 0;
            maxCnt = Math.max(maxCnt, cnt[s[j] - 'a']);
            if (i - j + 1 == k * maxCnt) {
                res = Math.min(res, dfs(j - 1, s, memo) + 1);
            }
        }
        memo[i] = res; // 记忆化
        return res;
    }
}