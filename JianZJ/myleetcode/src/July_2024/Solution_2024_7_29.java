package July_2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/7/29 8:28
 */
public class Solution_2024_7_29 {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (String operation : operations) {
            if ("+".equals(operation)) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else if ("D".equals(operation)) {
                list.add(list.get(list.size() - 1) * 2);
            } else if ("C".equals(operation)) {
                list.remove(list.size() - 1);
            } else {
                list.add(Integer.parseInt(operation));
            }
        }
        int ans = 0;
        for (Integer i : list) {
            ans += i;
        }
        return ans;
    }
}