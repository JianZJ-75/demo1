package test.test1;

/**
 * @Author JianZJ
 * @Date 2024/6/11 21:25
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i + " " + "hello!");
        }
    }
}