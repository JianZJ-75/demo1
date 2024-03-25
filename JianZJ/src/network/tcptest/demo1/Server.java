package network.tcptest.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/3/26 0:50
 */

/*
 * TCP通信练习1 --- 多发多收
 * 客户端：多次发送数据
 * 服务端接收多次接收数据，并打印
 * */

public class Server {
    public static void main(String[] args) throws IOException {
        // 初始化
        ServerSocket ss = new ServerSocket(1024);

        // 监听客户端
        Socket socket = ss.accept();

        // 接收数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }

        // 释放资源
        socket.close();
        ss.close();
    }
}
