import java.util.*;

/**
 * @Author: JianZJ
 * @Date: 2024/1/9 15:37
 */

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), L = sc.nextInt(), R = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++)
            h[i] = sc.nextInt();
        Arrays.sort(h);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int r = n - 1;
        int t = R - L;
        boolean ok = true;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            tmp.add(h[r]);
            r--;
        }
        while (true) {
            // 过
            for (int i = 0; i < t && r >= 0; i++) {
                tmp.add(h[r]);
                r--;
            }
            if (r < 0)
                break;
            for (Integer i : tmp) {
                if (i - 1 > 1)
                    pq.add(i - 1);
            }
            // 回
            if (pq.size() < L) {
                ok = false;
                break;
            }
            tmp = new ArrayList<>();
            for (int i = 0; i < L; i++) {
                tmp.add(pq.poll() - 1);
            }
        }
        if (ok)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}