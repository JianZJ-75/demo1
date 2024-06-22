package test.test11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author JianZJ
 * @Date 2024/6/22 2:57
 */

public class Server {
    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,                          // 核心线程数量
                21,                                     // 线程池大小
                60,                                     // 空闲时间
                TimeUnit.SECONDS,                       // 空闲时间(单位)
                new ArrayBlockingQueue<>(3),    // 阻塞队列
                Executors.defaultThreadFactory(),       // 线程工厂, 让线程池如何创建线程对象
                new ThreadPoolExecutor.AbortPolicy()    // 任务拒绝策略
        );

        ServerSocket ss = new ServerSocket(10011);
        while (true) {
            Socket socket = ss.accept();
            if (socket == null)
                continue;
            pool.submit(new MyRunnable(socket));
        }
    }
}
