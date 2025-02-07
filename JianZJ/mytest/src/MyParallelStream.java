import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author JianZJ
 * @Date 2025/1/27 23:06
 */

public class MyParallelStream {

    public void test1() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("并行");
        list.parallelStream().forEach(System.out::println);
        System.out.println("串行");
        list.stream().forEach(System.out::println);
    }

    public static void test2() throws InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        System.out.println(start);
        System.out.println(String.format("  >>> 电脑 CPU 并行处理线程数 :: %s, 并行流公共线程池内线程数 :: %s",
                Runtime.getRuntime().availableProcessors(),
                ForkJoinPool.commonPool().getParallelism()));
        List<String> stringList = new ArrayList();
        List<String> stringList2 = new ArrayList();
        for (int i = 0; i < 22; i++) stringList.add(String.valueOf(i));
        for (int i = 0; i < 5; i++) stringList2.add("任务2: " + String.valueOf(i));

        new Thread(() -> {
            stringList.parallelStream().forEach(each -> {
                System.out.println(Thread.currentThread().getName() + " 开始执行 :: " + each);
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }, "子线程-1").start();

        Thread.sleep(1500);

        LocalDateTime end = LocalDateTime.now();
        System.out.println(end);

        new Thread(() -> {
            stringList2.parallelStream().forEach(each -> {
                System.out.println(Thread.currentThread().getName() + " :: " + each);
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }, "子线程-2").start();
    }

    public static void test3() {
        ReentrantLock lock = new ReentrantLock();
    }

    public static void main(String[] args) throws InterruptedException {
        test2();
    }

}