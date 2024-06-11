package test.test2;

/**
 * @Author JianZJ
 * @Date 2024/6/11 21:32
 */
public class Demo {
    public static void main(String[] args) {
        /*
        * 多线程的第二种启动方式
        *   1. 自己定义一个类实现Runnable接口
        *   2. 重写里面的run方法
        *   3. 创建自己的类的对象
        *   4. 创建一个Thread类的对象, 并开启线程
        * */
        // 创建MyRun对象
        // 表示多线程要执行的任务
        MyRun r1 = new MyRun();

        // 创建线程对象
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.setName("线程1");
        t2.setName("线程2");

        // 开启线程
        t1.start();
        t2.start();

    }
}