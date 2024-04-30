package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/30 17:56
 */
public class Solution_2024_4_30 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int cnt = 0;
        for (int hour : hours) {
            if (hour >= target) {
                cnt++;
            }
        }
        return cnt;
    }
}
