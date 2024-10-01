package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/1 12:44
 */
public class Solution_10_1 {
    // TODO
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] isTravel = new boolean[lastDay + 1];
        for (int d : days) {
            isTravel[d] = true;
        }
        int[] memo = new int[lastDay + 1];
        return dfs(lastDay, isTravel, costs, memo);
    }

    private int dfs(int i, boolean[] isTravel, int[] costs, int[] memo) {
        if (i <= 0) {
            return 0;
        }
        if (memo[i] > 0) { // 之前计算过
            return memo[i];
        }
        if (!isTravel[i]) {
            return memo[i] = dfs(i - 1, isTravel, costs, memo);
        }
        return memo[i] = Math.min(dfs(i - 1, isTravel, costs, memo) + costs[0],
                Math.min(dfs(i - 7, isTravel, costs, memo) + costs[1],
                        dfs(i - 30, isTravel, costs, memo) + costs[2]));
    }
}