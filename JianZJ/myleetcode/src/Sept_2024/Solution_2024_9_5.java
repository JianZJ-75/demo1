package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/5 21:15
 */
public class Solution_2024_9_5 {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}