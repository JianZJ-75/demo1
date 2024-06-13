package test.test10;

/**
 * @Author JianZJ
 * @Date 2024/6/13 19:26
 */
public class MyRunnable implements Runnable{
    int ticket = 10;

    @Override
    public void run() {
        while (ticket > 0) {
            if (!shop())
                break;
        }
    }

    private synchronized boolean shop() {
        if (ticket <= 0)
            return false;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ticket--;
        System.out.println(Thread.currentThread().getName() + "当前正在卖第" + (10 - ticket) + "张票...");
        return true;
    }
}