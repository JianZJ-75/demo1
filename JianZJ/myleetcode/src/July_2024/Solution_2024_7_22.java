package July_2024;

import java.util.BitSet;

/**
 * @Author JianZJ
 * @Date 2024/7/22 16:34
 */
public class Solution_2024_7_22 {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        BitSet[] f = new BitSet[n];
        for (int i = 0; i < n; i++) {
            long x = bombs[i][0];
            long y = bombs[i][1];
            long r = bombs[i][2];
            f[i] = new BitSet(n);
            for (int j = 0; j < n; j++) {
                long dx = Math.abs(x - bombs[j][0]);
                long dy = Math.abs(y - bombs[j][1]);
                if (dx * dx + dy * dy <= r * r)
                    f[i].set(j);
            }
        }
        for (int k = 0; k < n; k++) {
            for (BitSet fi : f) {
                if (fi.get(k))
                    fi.or(f[k]);
            }
        }
        int ans = 0;
        for (BitSet bitSet : f) {
            ans = Math.max(ans, bitSet.cardinality());
        }
        return ans;
    }
}