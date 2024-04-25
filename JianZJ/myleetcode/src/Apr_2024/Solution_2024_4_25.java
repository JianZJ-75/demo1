package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/25 20:56
 */
public class Solution_2024_4_25 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank >= 5) {
            ans += 50;
            mainTank = mainTank - 5 + Math.min(additionalTank, 1);
            additionalTank = Math.max(additionalTank - 1, 0);
        }
        ans += 10 * mainTank;
        return ans;
    }
}
