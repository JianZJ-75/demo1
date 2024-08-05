package Aug_2024;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/8/5 20:35
 */
public class Solution_2024_8_5 {

    private static int[][] memo;

    public int findIntegers(int n) {
        int len = Integer.toBinaryString(n).length();
        memo = new int[len][2];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(len - 1, 0, true, n);
    }

    private int dfs(int i, int j, boolean flag, int n) {
        if (i < 0)
            return 1;
        if (!flag && memo[i][j] != -1)
            return memo[i][j];
        int ok = flag ? n >> i & 1 : 1;
        int res = dfs(i - 1, 0, flag && ok == 0, n);
        if (j != 1 && ok == 1)
        {
            res += dfs(i - 1, 1, flag, n);
        }
        memo[i][j] = res;
        return res;
    }

    @Test
    public void test() {
        System.out.println(findIntegers(13));
    }
}