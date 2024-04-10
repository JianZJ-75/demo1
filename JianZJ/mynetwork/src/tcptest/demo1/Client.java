package tcptest.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author JianZJ
 * @Date 2024/3/26 0:49
 */

/*
 * TCP通信练习1 --- 多发多收
 * 客户端：多次发送数据
 * 服务端接收多次接收数据，并打印
 * */

public class Client {
    public static void main(String[] args) throws IOException {
        // 初始化
        Socket socket = new Socket("127.0.0.1", 1024);
        Scanner sc = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();

        // 发送数据
        while (true)
        {
            System.out.println("请输入你要发送的信息：");
            String s = sc.nextLine();
            if ("bye".equals(s))
                break;
            os.write(s.getBytes());
        }

        // 释放资源
        socket.close();

    }
}
