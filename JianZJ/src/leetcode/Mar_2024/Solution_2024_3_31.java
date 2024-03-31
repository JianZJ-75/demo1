package leetcode.Mar_2024;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author JianZJ
 * @Date 2024/3/31 12:46
 */

public class Solution_2024_3_31 {
    public boolean isValidSerialization(String preorder) {
        String[] strings = preorder.split(",");
        Deque<String> dq = new ArrayDeque<>();
        int n = 1;
        int idx = -1;
        while (dq.size() < n) {
            idx++;
            if (idx >= strings.length)
                break;
            dq.offer(strings[idx]);
            if (!"#".equals(strings[idx]))
                n += 2;
        }
        if (dq.size() != n || idx != strings.length - 1)
            return false;
        else
            return true;
    }
}
