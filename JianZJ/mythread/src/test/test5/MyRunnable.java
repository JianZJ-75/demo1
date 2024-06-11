package test.test5;

/**
 * @Author JianZJ
 * @Date 2024/6/11 22:12
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " @ " + i);
        }
    }
}