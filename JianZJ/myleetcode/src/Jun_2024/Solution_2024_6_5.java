package Jun_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/5 18:35
 */
public class Solution_2024_6_5 {

    // 树状数组
    class TreeArray {
        private int[] p;
        private int n;

        public TreeArray(int n) {
            this.n = n;
            p = new int[n];
        }

        public int lowbit(int x) {
            return x & (-x);
        }

        public void add(int idx, int x) {
            while (idx < n) {
                p[idx] += x;
                idx += lowbit(idx);
            }
        }

        public int count(int idx) {
            int ans = 0;
            while (idx > 0) {
                ans += p[idx];
                idx -= lowbit(idx);
            }
            return ans;
        }
    }

    public int[] resultArray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int n = nums.length;

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(nums[0]);
        b.add(nums[1]);
        TreeArray t1 = new TreeArray(n + 1);
        TreeArray t2 = new TreeArray(n + 1);
        t1.add(Arrays.binarySearch(sorted, nums[0]) + 1, 1);
        t2.add(Arrays.binarySearch(sorted, nums[1]) + 1, 1);

        for (int i = 2; i < n; i++) {
            int x = nums[i];
            int v = Arrays.binarySearch(sorted, x) + 1;
            int flag1 = a.size() - t1.count(v);
            int flag2 = b.size() - t2.count(v);
            if (flag1 > flag2 || flag1 == flag2 && a.size() < b.size()) {
                a.add(x);
                t1.add(v, 1);
            } else {
                b.add(x);
                t2.add(v, 1);
            }
        }
        a.addAll(b);
        return a.stream().mapToInt(i -> i).toArray();
    }
}
