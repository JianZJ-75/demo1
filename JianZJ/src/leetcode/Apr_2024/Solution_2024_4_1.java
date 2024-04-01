package leetcode.Apr_2024;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author JianZJ
 * @Date 2024/4/1 17:16
 */
public class Solution_2024_4_1 {
    public String finalString(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        int n = s.length();
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'i')
                ok = !ok;
            else if (ok)
                dq.addLast(s.charAt(i));
            else
                dq.addFirst(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (var i : dq)
            sb.append(i);
        if (!ok)
            sb.reverse();
        return sb.toString();
    }
}
