package test.test6;

/**
 * @Author JianZJ
 * @Date 2024/6/11 22:18
 */
public class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " @ " + i);
        }
    }
}