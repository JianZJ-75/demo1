package test.test11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author JianZJ
 * @Date 2024/6/13 19:00
 */
public class MyThread extends Thread {
    static int ticket = 10;

    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket--;
                    System.out.println(getName() + "当前正在卖第" + (10 - ticket) + "张票...");

                } else
                    break;
            } finally {
                lock.unlock();
            }
        }
    }
}