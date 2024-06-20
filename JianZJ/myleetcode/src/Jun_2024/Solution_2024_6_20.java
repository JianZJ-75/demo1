package Jun_2024;

/**
 * @Author JianZJ
 * @Date 2024/6/20 8:51
 */
public class Solution_2024_6_20 {
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] cnt = new int[10];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 1; j < 10; j++)
                if (cnt[j] > 0 && gcd(j, x % 10) == 1)
                    ans += cnt[j];
            while (x > 10)
                x /= 10;
            cnt[x]++;
        }
        return ans;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        return b != 0 ? gcd(b, a % b) : a;
    }
}