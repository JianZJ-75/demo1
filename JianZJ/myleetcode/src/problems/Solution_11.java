package problems;

/**
 * @Author JianZJ
 * @Date 2025/1/11 17:34
 */
public class Solution_11 {

    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int tmp = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, tmp);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

}