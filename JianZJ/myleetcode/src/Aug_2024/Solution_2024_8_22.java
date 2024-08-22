package Aug_2024;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/8/22 22:14
 */
public class Solution_2024_8_22 {
    public long minEnd(int n, int x) {
        if (n == 1) {
            return x;
        }
        List<Integer> xx = new ArrayList<>();
        List<Integer> nn = new ArrayList<>();
        while (x > 0) {
            xx.add(x % 2);
            x /= 2;
        }
        n--;
        while (n > 0) {
            nn.add(n % 2);
            n /= 2;
        }
        int cnt = 0;
        for (int i = 0; i < xx.size(); i++) {
            if (xx.get(i) == 0 && cnt < nn.size()) {
                xx.set(i, nn.get(cnt));
                cnt++;
            }
        }
        while (cnt < nn.size()) {
            xx.add(nn.get(cnt));
            cnt++;
        }
        long ans = 0;
        for (int i = 0; i < xx.size(); i++) {
            if (xx.get(i) == 1) {
                ans += (long) 1 << i;
            }
        }
        return ans;
    }

    @Test
    public void test() {
//        System.out.println(minEnd(4, 1));
//        System.out.println(minEnd(3, 4));
        System.out.println(minEnd(2, 4));
    }
}