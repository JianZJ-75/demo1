package test.practice1.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/14 18:42
 */
public class MyThread extends Thread{

    static List<Integer> prizePool;

    List<Integer> now = new ArrayList<>();
    int max = 0;
    int sum = 0;

    public MyThread(List<Integer> prizePool) {
        this.prizePool = prizePool;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (MyThread.class) {
                if (prizePool.size() == 0)
                    break;
                else {
                    Collections.shuffle(prizePool);
                    int prize = prizePool.remove(0);
                    now.add(prize);
                    max = Math.max(max, prize);
                    sum += prize;
                }
            }
        }
        synchronized (MyThread.class) {
            System.out.println("在此次抽奖过程中, " + getName() + "总共产生了" + now.size() + "个奖项");
            System.out.print("分别为: ");
            for (int i = 0; i < now.size(); i++) {
                System.out.print(now.get(i));
                if (i != now.size() - 1)
                    System.out.print(",");
            }
            System.out.println("最高奖项为" + max + "元, 总计额为" + sum + "元");
        }
    }
}