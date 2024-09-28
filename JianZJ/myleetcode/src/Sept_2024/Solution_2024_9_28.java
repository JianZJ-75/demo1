package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/28 18:44
 */
public class Solution_2024_9_28 {
    // TODO
    class BookMyShow {
        private int n;
        private int m;
        private int[] min;
        private long[] sum;

        public BookMyShow(int n, int m) {
            this.n = n;
            this.m = m;
            int size = 2 << (32 - Integer.numberOfLeadingZeros(n)); // 比 4n 更小
            min = new int[size];
            sum = new long[size];
        }

        public int[] gather(int k, int maxRow) {
            // 找第一个能倒入 k 升水的水桶
            int r = findFirst(1, 0, n - 1, maxRow, m - k);
            if (r < 0) { // 没有这样的水桶
                return new int[]{};
            }
            int c = (int) querySum(1, 0, n - 1, r, r);
            update(1, 0, n - 1, r, k); // 倒水
            return new int[]{r, c};
        }

        public boolean scatter(int k, int maxRow) {
            // [0,maxRow] 的接水量之和
            long s = querySum(1, 0, n - 1, 0, maxRow);
            if (s > (long) m * (maxRow + 1) - k) {
                return false; // 水桶已经装了太多的水
            }
            // 从第一个没有装满的水桶开始
            int i = findFirst(1, 0, n - 1, maxRow, m - 1);
            while (k > 0) {
                int left = Math.min(m - (int) querySum(1, 0, n - 1, i, i), k);
                update(1, 0, n - 1, i, left); // 倒水
                k -= left;
                i++;
            }
            return true;
        }

        // 把下标 i 上的元素值增加 val
        private void update(int o, int l, int r, int i, int val) {
            if (l == r) {
                min[o] += val;
                sum[o] += val;
                return;
            }
            int m = (l + r) / 2;
            if (i <= m) {
                update(o * 2, l, m, i, val);
            } else {
                update(o * 2 + 1, m + 1, r, i, val);
            }
            min[o] = Math.min(min[o * 2], min[o * 2 + 1]);
            sum[o] = sum[o * 2] + sum[o * 2 + 1];
        }

        // 返回区间 [L,R] 内的元素和
        private long querySum(int o, int l, int r, int L, int R) {
            if (L <= l && r <= R) {
                return sum[o];
            }
            long res = 0;
            int m = (l + r) / 2;
            if (L <= m) {
                res = querySum(o * 2, l, m, L, R);
            }
            if (R > m) {
                res += querySum(o * 2 + 1, m + 1, r, L, R);
            }
            return res;
        }

        // 返回区间 [0,R] 中 <= val 的最靠左的位置，不存在时返回 -1
        private int findFirst(int o, int l, int r, int R, int val) {
            if (min[o] > val) {
                return -1; // 整个区间的元素值都大于 val
            }
            if (l == r) {
                return l;
            }
            int m = (l + r) / 2;
            if (min[o * 2] <= val) {
                return findFirst(o * 2, l, m, R, val);
            }
            if (R > m) {
                return findFirst(o * 2 + 1, m + 1, r, R, val);
            }
            return -1;
        }
    }
}