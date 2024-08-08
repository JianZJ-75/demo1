package Aug_2024;

/**
 * @Author JianZJ
 * @Date 2024/8/8 19:41
 */
public class Solution_2024_8_8 {
    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            min1 = Math.min(min1, nums1[i]);
            min2 = Math.min(min2, nums2[i]);
        }
        return min2 - min1;
    }
}