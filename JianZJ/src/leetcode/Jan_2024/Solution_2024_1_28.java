package leetcode.Jan_2024;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author: JianZJ
 * @Date: 2024/1/28 16:55
 */
public class Solution_2024_1_28 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity)
            return false;
        if (targetCapacity % gcd(jug1Capacity, jug2Capacity) != 0)
            return false;
        return true;
    }
    public int gcd(int x, int y) {
        if (x < y) {
            int t = x;
            x = y;
            y = t;
        }
        if (y == 0)
            return x;
        else
            return gcd(x % y, y);
    }
}