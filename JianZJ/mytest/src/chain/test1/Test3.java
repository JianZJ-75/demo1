package chain.test1;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2025/4/14 19:52
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        List<Integer> a = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            a.add(x);
            set.add(x);
        }
        int cnt = set.size();
        List<Integer> b = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            b.add(a.get(i));
        }
        int l = 0, r = 0;
        for (int i = 0; i < q; i++) {
            char c = sc.next().charAt(0);
            int x = sc.nextInt();
            if (c == 'L') {
                if (x >= n) {
                    System.out.println(cnt);
                    l += x;
                    l %= n;
                } else {
                    set.clear();
                    for (int j = 0; j < x; j++) {
                        set.add(a.get(l));
                        l++;
                        l %= n;
                    }
                    System.out.println(set.size());
                }
            } else {
                if (x >= n) {
                    System.out.println(cnt);
                    r += x;
                    r %= n;
                } else {
                    set.clear();
                    for (int j = 0; j < x; j++) {
                        set.add(b.get(r));
                        r++;
                        r %= n;
                    }
                    System.out.println(set.size());
                }
            }
        }
    }

}