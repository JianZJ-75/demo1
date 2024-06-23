package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/23 15:42
 */
public class Solution_2024_6_23 {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (check(word.charAt(i)))
                cnt++;
        }
        return cnt == n || cnt == 0 || cnt == 1 && check(word.charAt(0)) ? true : false;
    }

    private boolean check(char t) {
        return t <= 'Z' && t >= 'A';
    }
}