package Sept_2024;

/**
 * @Author JianZJ
 * @Date 2024/9/14 22:31
 */
public class Solution_2024_9_14 {
    // TODO`    `
    public String removeStars(String s) {
        StringBuilder st = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                st.deleteCharAt(st.length() - 1);
            } else {
                st.append(c);
            }
        }
        return st.toString();
    }
}