package leetcode.Jan_2024;

/**
 * @Author: JianZJ
 * @Date: 2024/1/13 1:14
 */
public class Solution2024_1_13 {
    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] a = new int[30];
        int m = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
            a[s.charAt(i) - 'a' + 1]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 26, j = 26; i > 0 && j > 0;) {
            if (a[i] == 0) {
              i--;
              m = 0;
            } else if (m < repeatLimit) {
                sb.append((char)('a' + i - 1));
                a[i]--;
                m++;
            }else if (j >= i || a[j] == 0)
                j--;
            else {
                sb.append((char)('a' + j - 1));
                a[j]--;
                m = 0;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(repeatLimitedString("cczazcc", 3));
        System.out.println(repeatLimitedString("aababab", 2));
    }
}
