package test.test5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/6/21 20:42
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocket对象
        ServerSocket ss = new ServerSocket(1024);

        // 监听客户端的连接
        // 死等
        Socket accept = ss.accept();

        // 从连接通道中获取输入流读取数据
        InputStream is = accept.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }

        // 释放资源
        is.close();
        accept.close();
        ss.close();

    }
}