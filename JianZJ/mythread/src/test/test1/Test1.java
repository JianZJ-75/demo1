package test.test1;

/**
 * @Author JianZJ
 * @Date 2024/6/11 21:24
 */
public class Test1 {
    public static void main(String[] args) {
        /*
        * 多线程的第一种启动方式:
        *   1. 自己定义一个类继承Thread
        *   2. 重写run方法
        *   3. 创建子类的对象, 并启动线程
        * */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("thread1");
        t2.setName("thread2");

        // 开启线程
        t1.start();
        t2.start();
    }
}