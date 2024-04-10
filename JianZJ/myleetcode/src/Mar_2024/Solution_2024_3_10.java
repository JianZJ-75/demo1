package Mar_2024;

/**
 * @Author JianZJ
 * @Date 2024/3/10 15:37
 */
public class Solution_2024_3_10 {
    public String getHint(String secret, String guess) {
        int[] cnt = new int[10];
        int n = secret.length();
        for (int i = 0; i < n; i++) {
            cnt[secret.charAt(i) - '0']++;
        }
        int bulls = 0, cows = 0;
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bulls++;
            int t = guess.charAt(i) - '0';
            if (cnt[t] > 0) {
                cnt[t]--;
                cows++;
            }
        }
        cows -= bulls;
        return new String(bulls + "A" + cows + "B");
    }
}
