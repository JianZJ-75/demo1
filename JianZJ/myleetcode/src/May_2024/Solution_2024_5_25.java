package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/25 1:19
 */
public class Solution_2024_5_25 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int maxId = 0;
        int minId = 0;
        for (int j = indexDifference; j < nums.length; j++) {
            int i = j - indexDifference;
            if (nums[i] > nums[maxId]) {
                maxId = i;
            } else if (nums[i] < nums[minId]) {
                minId = i;
            }
            if (nums[maxId] - nums[j] >= valueDifference) {
                return new int[]{j, maxId};
            }
            if (nums[j] - nums[minId] >= valueDifference) {
                return new int[]{j, minId};
            }
        }
        return new int[]{-1, -1};
    }
}
