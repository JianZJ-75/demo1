package Oct_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/10/3 18:08
 */
public class Solution_10_3 {
    // TODO
    private static final int INF_VALUE = 1000001;

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int[][] dp = new int[n][maxTime + 1];     // dp[i][t]表示时间t到达节点i的最小花费
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], INF_VALUE);        // 初始都为极大值，保证更新到最小值
        }
        dp[0][0] = passingFees[0];                // 初始时间0在起点0，花费为节点0的通行费
        // 状态转移
        for(int t = 1; t <= maxTime; t++){
            for(int[] e: edges){
                int x = e[0], y = e[1], time = t - e[2];                        // time表示到达上一个点的时间
                if(time < 0)continue;                                           // 不可能在时间t内通过x-y这条边到达x或y
                dp[x][t] = Math.min(dp[x][t], dp[y][time] + passingFees[x]);    // 更新到达当前点的开销
                dp[y][t] = Math.min(dp[y][t], dp[x][time] + passingFees[y]);
            }
        }
        int res = INF_VALUE;                     // 到达n-1的最小开销的就是所有时间里的最小值
        for(int t = 1; t <= maxTime; t++){
            res = Math.min(res, dp[n-1][t]);
        }
        return res == INF_VALUE ? -1: res;       // 修正结果
    }
}