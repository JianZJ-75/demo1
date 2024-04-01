package network.tcptest.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/3/31 0:29
 */

/*
* TCP通信练习2 --- 接收和反馈
* 客户端：发送一条数据，接收服务器反馈的消息并打印
* 服务端：接收数据并打印，再给客户反馈消息
* */

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 1024);
        OutputStream os = socket.getOutputStream();
        String s1 = "你好!";
        os.write(s1.getBytes());

        // 写出一个结束标记
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }

        socket.close();
    }
}
