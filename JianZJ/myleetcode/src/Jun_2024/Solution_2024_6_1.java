package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/1 22:24
 */
public class Solution_2024_6_1 {
    public int distributeCandies(int n, int limit) {
        return c(n + 2) - 3 * c(n - limit + 1) + 3 * c(n - 2 * limit) - c(n - 3 * limit - 1);
    }

    private int c(int n) {
        return n > 1 ? n * (n - 1) / 2 : 0;
    }
}
