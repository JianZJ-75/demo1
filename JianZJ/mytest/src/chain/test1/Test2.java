package chain.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author JianZJ
 * @Date 2025/4/14 19:47
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        List<Integer> a = new ArrayList<Integer>();
        for (String i : split) {
            int n = i.length();
            int j = 0;
            int ok = 1;
            if (i.charAt(j) == '-') {
                ok = -1;
                j++;
            }
            int sum = 0;
            for (; j < n; j++) {
                sum = sum * 10 + i.charAt(j) - '0';
            }
            sum *= ok;
            a.add(sum);
        }
        Collections.sort(a);
        int n = a.size();
        System.out.println(Math.max(a.get(0) * a.get(1) * a.get(n - 1), a.get(n - 1) * a.get(n - 2) * a.get(n - 3)));
    }

}