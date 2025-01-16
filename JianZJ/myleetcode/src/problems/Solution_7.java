package problems;

/**
 * @Author JianZJ
 * @Date 2025/1/10 22:29
 */
public class Solution_7 {

    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE)
            ans = 0;
        return (int) ans;
    }

}