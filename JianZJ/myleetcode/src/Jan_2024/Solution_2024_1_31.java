package Jan_2024;

import java.util.Arrays;

/**
 * @Author: JianZJ
 * @Date: 2024/1/31 15:23
 */
public class Solution_2024_1_31 {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] mp = new int[60];
        boolean[] ok = new boolean[60];
        for (int i = 0; i < n; i++) {
            mp[nums[i]]++;
        }
        int cnt = 0;
        for (int i = 1; i <= 50; i++)
            if (mp[i] != 0)
                cnt--;
        if (mp[nums[0]] == 1)
            res[0] = cnt + 2;
        else
            res[0] = cnt + 1;
        mp[nums[0]]--;
        ok[nums[0]] = true;
        for (int i = 1; i < n; i++) {
            mp[nums[i]]--;
            if (ok[nums[i]]) {
                if (mp[nums[i]] == 0)
                    res[i] = res[i - 1] + 1;
                else
                    res[i] = res[i - 1];
            } else {
                if (mp[nums[i]] == 0)
                    res[i] = res[i - 1] + 2;
                else
                    res[i] = res[i - 1] + 1;
            }
            ok[nums[i]] = true;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_2024_1_31 q = new Solution_2024_1_31();
        int[] a = new int[]{13,13,13};
        System.out.println(Arrays.toString(q.distinctDifferenceArray(a)));
    }
}
