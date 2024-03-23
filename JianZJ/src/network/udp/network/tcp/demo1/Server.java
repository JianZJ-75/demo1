package network.udp.network.tcp.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/3/24 0:47
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // TCP协议，接收数据

        // 1.创建对象ServerSocket
        ServerSocket ss = new ServerSocket(1024);

        // 2.监听客户端的连接
        Socket socket = ss.accept();

        // 3.从连接通道中获取输入流数据
        InputStream is = socket.getInputStream();
        int b;
        while ((b = is.read()) != -1) {
            System.out.println((char) b);
        }

        // 4.释放资源
        socket.close();
        ss.close();

    }
}
