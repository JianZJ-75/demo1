package test.test11;

/**
 * @Author JianZJ
 * @Date 2024/6/13 19:00
 */
public class MyThread extends Thread {
    static int ticket = 10;

    static Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            // 同步代码块
            synchronized (lock) {
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
            }
        }
    }
}