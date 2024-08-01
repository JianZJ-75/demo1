package Aug_2024;

import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/8/1 20:16
 */
public class Solution_2024_8_1 {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int n = cards.length;
        int ans = 0;
        for (int i = n - 1; i >= n - cnt; i--) {
            ans += cards[i];
        }
        if (ans % 2 == 0)
            return ans;
        int min_odd = 0, min_even = 0;
        int max_odd = 0, max_even = 0;
        for (int i = 0; i < n - cnt; i++) {
            if (cards[i] % 2 == 0)
                max_even = Math.max(max_even, cards[i]);
            if (cards[i] % 2 != 0)
                max_odd = Math.max(max_odd, cards[i]);
        }
        for (int i = n - cnt; i < n; i++) {
            if (cards[i] % 2 == 0 && min_even == 0)
                min_even = cards[i];
            if (cards[i] % 2 != 0 && min_odd == 0)
                min_odd = cards[i];
        }
        int ans1 = 0, ans2 = 0;
        if (min_odd != 0 && max_even != 0)
            ans1 = ans - min_odd + max_even;
        if (min_even != 0 && max_odd != 0)
            ans2 = ans - min_even + max_odd;
        return Math.max(ans1, ans2);
    }
}