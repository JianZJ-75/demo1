package Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/28 18:30
 */
public class Solution_2024_4_28 {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        int k = 1;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            if (n % 2 != 0) {
                sb.append(1);
                n -= k;
            } else {
                sb.append(0);
            }
            k *= -1;
            n /= 2;
        }
        return sb.reverse().toString();
    }
}
