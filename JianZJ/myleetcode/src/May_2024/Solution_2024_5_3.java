package May_2024;

/**
 * @Author JianZJ
 * @Date 2024/5/3 20:21
 */
public class Solution_2024_5_3 {
    public double average(int[] salary) {
        int sum = 0;
        int mx = salary[0];
        int mi = salary[0];
        int n = salary.length;
        for (int i : salary) {
            sum += i;
            mx = Math.max(mx, i);
            mi = Math.min(mi, i);
        }
        return (double) (sum - mi - mx) / (n - 2);
    }
}
