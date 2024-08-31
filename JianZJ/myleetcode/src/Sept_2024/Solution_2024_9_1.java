package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/1 0:59
 */
public class Solution_2024_9_1 {
    // TODO
    public int busyStudent(int[] st, int[] et, int t) {
        int[] c = new int[1010];
        for (int i = 0; i < st.length; i++) {
            c[st[i]]++; c[et[i] + 1]--;
        }
        for (int i = 1; i <= t; i++) c[i] += c[i - 1];
        return c[t];
    }
}