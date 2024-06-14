package test.practice1.test2;

import java.util.Collections;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/14 18:42
 */
public class MyThread extends Thread{

    static List<Integer> prizePool;

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
                    System.out.println(getName() + "产生了一个" + prize + "元大奖");
                }
            }
        }
    }
}