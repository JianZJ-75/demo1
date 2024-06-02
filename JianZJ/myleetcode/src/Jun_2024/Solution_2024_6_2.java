package Jun_2024;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author JianZJ
 * @Date 2024/6/2 10:38
 */
public class Solution_2024_6_2 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (var i : candyType) {
            set.add(i);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
