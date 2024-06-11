package test.test4;

/**
 * @Author JianZJ
 * @Date 2024/6/11 21:54
 */
public class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
        super();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " @ " + i);
        }
    }
}