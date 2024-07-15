package July_2024;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author JianZJ
 * @Date 2024/7/16 0:02
 */
public class Solution_2024_7_16 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int x = 0;
        int y = 0;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int i : nums1) {
            s1.add(i);
        }
        for (int i : nums2) {
            s2.add(i);
        }
        for (int i : nums1) {
            if (s2.contains(i)) {
                x++;
            }
        }
        for (int i : nums2) {
            if (s1.contains(i)) {
                y++;
            }
        }
        return new int[]{x, y};
    }
}