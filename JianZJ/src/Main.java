import java.util.*;

/**
 * @Author: JianZJ
 * @Date: 2024/1/9 15:37
 */

public class Main {
    public static void main(String[] args) {
        String q = "Dada";
        q = new StringBuilder(q).reverse().toString();
        System.out.println(new Main().lastNonEmptyString("aabcbbca"));
    }
    public String lastNonEmptyString(String s) {
        String res = new String();
        Map<Character, List<Integer>> mp = new HashMap<>();
        int n = s.length();
        int mx = 0;
        for (int i = 0; i < n; i++) {
            char j = s.charAt(i);
            mp.computeIfAbsent(j, t -> new ArrayList<>()).add(i);
            mp.putIfAbsent(j, new ArrayList<>());
            mp.get(j).add(i);
            mx = Math.max(mx, mp.get(j).size());
        }
        List<Integer> ans = new ArrayList<>();
        for (List<Integer> i : mp.values()) {
            if (i.size() == mx)
                ans.add(i.get(mx - 1));
        }
        ans.sort((a, b) -> a - b);
        for (int i : ans)
            res += s.charAt(i);
        return res;
    }
}