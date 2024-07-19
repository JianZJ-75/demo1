package July_2024;

/**
 * @Author JianZJ
 * @Date 2024/7/19 15:35
 */
public class Solution_2024_7_19 {
    public int minimumLevels(int[] possible) {
        int a = possible[0] == 1 ? 1 : -1, b = 0;
        int n = possible.length;
        for (int i = 1; i < n; i++) {
            if (possible[i] == 1)
                b++;
            else
                b--;
        }
        int l = 1;
        while (a <= b) {
            l++;
            if (l >= n)
                return -1;
            if (possible[l - 1] == 1) {
                a++;
                b--;
            } else {
                a--;
                b++;
            }
        }
        return l;
    }
}