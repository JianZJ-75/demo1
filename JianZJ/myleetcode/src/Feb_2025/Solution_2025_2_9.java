package Feb_2025;

/**
 * @Author JianZJ
 * @Date 2025/2/9 20:55
 */
public class Solution_2025_2_9 {

    public int removeDuplicates(int[] nums) {
        int l = 0, r = 1, cnt = 1;
        while (r < nums.length) {
            if (nums[r] == nums[l]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt <= 2) {
                l++;
                nums[l] = nums[r];
            }
            r++;
        }
        return l + 1;
    }

}