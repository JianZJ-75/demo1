package Oct_2024;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Author JianZJ
 * @Date 2024/10/25 21:51
 */
public class Solution_10_25 {
    // TODO
    public int maxTotalReward(int[] rewardValues) {
        BigInteger f = BigInteger.ONE;
        for (int v : Arrays.stream(rewardValues).distinct().sorted().toArray()) {
            BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(v));
        }
        return f.bitLength() - 1;
    }
}