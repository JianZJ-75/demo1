package network.tcptest.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/3/31 0:31
 */

/*
 * TCP通信练习2 --- 接收和反馈
 * 客户端：发送一条数据，接收服务器反馈的消息并打印
 * 服务端：接收数据并打印，再给客户反馈消息
 * */

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1024);

        Socket socket = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int b;
        // 细节：
        // read方法会从连接通道中读取数据
        // 但是，需要有一个结束标记，此处的循环才会停止
        // 否则，程序就会一直停在read方法这里，等待读取下面的数据
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }

        OutputStream os = socket.getOutputStream();
        String s2 = "一点也不好!";
        os.write(s2.getBytes());

        socket.close();
        ss.close();
    }
}
