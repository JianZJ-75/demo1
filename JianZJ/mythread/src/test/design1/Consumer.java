package test.design1;

/**
 * @Author JianZJ
 * @Date 2024/6/13 20:56
 */
public class Consumer extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0)
                    break;
                else {
                    if (Desk.flag == 0) {
                        System.out.println("wait producer produce...");
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("consumer shopping...                    " + Desk.count);
                        Desk.count--;
                        Desk.flag--;
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        Desk.lock.notifyAll();
                        System.out.println("notify producer...");
                    }
                }
            }
        }
    }
}