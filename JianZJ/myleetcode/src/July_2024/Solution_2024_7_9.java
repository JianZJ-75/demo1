package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/8 18:38
 */
public class Solution_2024_7_9 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (l * 2 == sum - nums[i])
                return i;
            l += nums[i];
        }
        return -1;
    }
}