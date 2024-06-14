package test.practice1.test1;

import java.util.Random;

/**
 * @Author JianZJ
 * @Date 2024/6/14 18:29
 */
public class MYThread extends Thread{

    static int money = 10000;
    static int count = 3;

    static final int MIN = 1;

    @Override
    public void run() {
        synchronized (MYThread.class) {
            if (count == 0)
                System.out.println(getName() + "没有抢到红包!");
            else {
                int prize = 0;
                if (count == 1)
                    prize = money;
                else {
                    Random r = new Random();
                    prize = r.nextInt(money - (count - 1));
                    prize = Math.max(MIN, prize);
                }
                money -= prize;
                count--;
                System.out.println(getName() + "抢到了" + 1.0 * prize / 100 + "元!");
            }
        }
    }
}