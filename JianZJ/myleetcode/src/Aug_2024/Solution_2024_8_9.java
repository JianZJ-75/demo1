package Aug_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/8/9 10:57
 */
public class Solution_2024_8_9 {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 2; i > 0; i--) {
            int x = nums2[0] - nums1[i];
            int j = 0;
            for (int k = i; k < nums1.length; k++) {
                if (nums1[k] + x == nums2[j] && ++j == nums2.length) {
                    return x;
                }
            }
        }
        return nums2[0] - nums1[0];
    }
}