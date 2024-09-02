package Sept_2024;

import org.junit.Test;

/**
 * @Author JianZJ
 * @Date 2024/9/2 19:03
 */
public class Solution_2024_9_2 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int l = 0;
        int ans = 1;
        int cnt = 0;
        for (int r = 0; r < n; r++) {
            if (answerKey.charAt(r) == 'T') {
                cnt++;
            }
            while (r - l + 1 - cnt > k) {
                if (answerKey.charAt(l) == 'T') {
                    cnt--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        l = 0;
        cnt = 0;
        for (int r = 0; r < n; r++) {
            if (answerKey.charAt(r) == 'F') {
                cnt++;
            }
            while (r - l + 1 - cnt > k) {
                if (answerKey.charAt(l) == 'F') {
                    cnt--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}