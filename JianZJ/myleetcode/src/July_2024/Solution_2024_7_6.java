package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/6 3:56
 */
public class Solution_2024_7_6 {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ) {
            int j = i + 1;
            int len = 1;
            while (j < n && nums[j - 1] != nums[j]) {
                j++;
                len++;
            }
            ans += (1l + len) * len / 2;
            i = j;
        }
        return ans;
    }
}