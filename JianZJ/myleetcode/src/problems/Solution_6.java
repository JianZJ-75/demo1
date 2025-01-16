package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2025/1/10 22:24
 */
public class Solution_6 {

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<StringBuilder> tmp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            tmp.add(new StringBuilder());
        }
        int ok = -1;
        int now = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i % numRows == numRows - 1)
                ok *= -1;
            now += ok * 1;
            tmp.get(now).append(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ans.append(tmp.get(now));
        }
        return ans.toString();
    }

}