package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/7 0:35
 */
public class Solution_2024_6_7 {
    public int maxOperations(int[] nums) {
        int ans = 1;
        int sum = nums[0] + nums[1];
        for (int i = 3; i < nums.length; i += 2) {
            if (nums[i] + nums[i - 1] == sum)
                ans++;
            else
                break;
        }
        return ans;
    }
}