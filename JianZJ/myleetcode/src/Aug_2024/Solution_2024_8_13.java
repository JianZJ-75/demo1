package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/13 23:00
 */
public class Solution_2024_8_13 {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                return false;
            }
        }
        return true;
    }
}