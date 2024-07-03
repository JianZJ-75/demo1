package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/3 21:06
 */
public class Solution_2024_7_3 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int tmp = x;
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return tmp % sum == 0 ? sum : -1;
    }
}