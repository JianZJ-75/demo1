import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: JianZJ
 * @Date: 2024/1/9 15:37
 */

public class Main {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] p = new int[n][2];
        Arrays.sort(p, (a, b) -> a[1] - b[1]);
        int[] ans = new int[n];

        return ans;
    }
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int[][] p = new int[n][2];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i);
            int b = nums2.get(i);
            p[i][0] = a;
            p[i][1] = b;
            sum1 += a;
            sum2 += b;
        }
        Arrays.sort(p, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j > 0; j--)
                dp[j] = Math.max(dp[j], dp[j - 1] + p[i][0] + j * p[i][1]);
        for (int i = 0; i <=n ; i++)
            if (sum1 + sum2 * i - dp[i] <= x)
                return i;
        return -1;
    }
    public static void main(String[] args) {
        Integer[] array = {4, 2, 8, 1, 6};

        // 使用 Lambda 表达式定义升序排序规则
        Arrays.sort(array, (a, b) -> a - b);

        // 输出排序后的数组
        System.out.println(Arrays.toString(array));
        int t = 1;
        Integer q = t;
        System.out.println(q);
    }
}