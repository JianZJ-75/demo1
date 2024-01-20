package leetcode;

/**
 * @Author: JianZJ
 * @Date: 2024/1/16 1:11
 */
public class Solution_2024_1_16 {
    static final int N = 23;
    static final int M = 401;
    static final int MOD = 1000000007;
    int[][] dp;
    String s;
    int min_sum;
    int max_sum;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        dp = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                    dp[i][j] = -1;
        this.min_sum = min_sum;
        this.max_sum = max_sum;
        return (get(num2) - get(sub(num1)) + MOD) % MOD;
    }

    public String sub(String num) {
        char[] t = num.toCharArray();
        int len = t.length - 1;
        while (t[len] == '0')
            len--;
        t[len]--;
        len++;
        while (len < t.length) {
            t[len] = '9';
            len++;
        }
        return new String(t);
    }

    public int get(String num) {
        this.s = new StringBuilder(num).reverse().toString();
        return dfs(s.length() - 1, 0, true);
    }

    public int dfs(int i, int j, boolean ok) {
        if (j > max_sum)
            return 0;
        if (i == -1)
        {
            if (j >= min_sum)
                return 1;
            else
                return 0;
        }
        if (!ok && dp[i][j] != -1)
            return dp[i][j];
        int ans = 0;
        int r = 9;
        if (ok)
            r = s.charAt(i) - '0';
        for (int t = 0; t <= r; t++) {
            ans += dfs(i - 1, j + t, ok && t == r);
            ans %= MOD;
        }
        if (!ok)
            dp[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_2024_1_16().count("1", "12", 1, 8));
        System.out.println(new Solution_2024_1_16().count("1", "5", 1, 5));
    }
}