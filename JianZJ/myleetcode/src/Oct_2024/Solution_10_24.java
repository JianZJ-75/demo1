package Oct_2024;

/**
 * @Author JianZJ
 * @Date 2024/10/24 21:26
 */
public class Solution_10_24 {
    // TODO
    public int findWinningPlayer(int[] skills, int k) {
        int maxI = 0;
        int win = 0;
        for (int i = 1; i < skills.length && win < k; i++) {
            if (skills[i] > skills[maxI]) { // 打擂台，发现新的最大值
                maxI = i;
                win = 0;
            }
            win++; // 获胜回合 +1
        }
        // 如果 k 很大，那么 maxI 就是 skills 最大值的下标，毕竟最大值会一直赢下去
        return maxI;
    }
}