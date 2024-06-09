package Jun_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/6/10 0:44
 */
public class Solution_2024_6_10 {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int l = 0, r = n - 1;
        int ans = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }
            r--;
            ans++;
        }
        return ans;
    }
}