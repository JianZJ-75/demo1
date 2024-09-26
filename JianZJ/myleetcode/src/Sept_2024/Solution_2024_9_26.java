package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/26 18:34
 */
public class Solution_2024_9_26 {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int pre = 0;
        for (int x : nums) {
            pre += x;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
        }
        return Math.abs(sum - pre);
    }
}