package leetcode.Apr_2024;

/**
 * @Author JianZJ
 * @Date 2024/4/10 12:53
 */
public class Solution_2024_4_10 {
    public String maximumBinaryString(String binary) {
        int i = binary.indexOf("0");
        int n = binary.length();
        if (i == -1)
            return binary;
        int cnt = 0;
        for (; i < n; i++) {
            if (binary.charAt(i) == '1') {
                cnt++;
            }
        }
        return "1".repeat(n - cnt - 1) + "0" + "1".repeat(cnt);
    }
}
