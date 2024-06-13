package test.design1;

/**
 * @Author JianZJ
 * @Date 2024/6/13 20:56
 */
public class Producer extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0)
                    break;
                else {
                    if (Desk.flag != 0) {
                        System.out.println("wait consumer shopping...");
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("producer producing...");
                        Desk.flag++;
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        Desk.lock.notifyAll();
                        System.out.println("notify consumer...");
                    }
                }
            }
        }
    }
}