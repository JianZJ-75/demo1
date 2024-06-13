package test.test9;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author JianZJ
 * @Date 2024/6/13 18:51
 */
public class MyRunnable implements Runnable{
    static AtomicInteger Max = new AtomicInteger(10);

    @Override
    public void run() {
        while (Max.get() > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了一张票" + "还剩" + Max.decrementAndGet() + "张票");
        }
    }
}
