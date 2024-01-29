package leetcode.Jan_2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: JianZJ
 * @Date: 2024/1/20 2:55
 */
public class Solution_2024_1_20 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new LinkedList<String>();
        for (String i : words) {
            int n = i.length();
            int l = 0;
            for (int j = 0; j < n; j++) {
                if (i.charAt(j) == separator) {
                    if (l != j)
                        res.add(i.substring(l, j));
                    l = j + 1;
                }
            }
            if (l < n)
                res.add(i.substring(l));
        }
        return res;
    }
}
