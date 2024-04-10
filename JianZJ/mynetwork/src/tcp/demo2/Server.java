package tcp.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/3/24 1:14
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // TCP协议，接收数据

        // 1.创建对象ServerSocket
        ServerSocket ss = new ServerSocket(1024);

        // 2.监听客户端的连接
        Socket socket = ss.accept();

        // 3.从连接通道中获取输入流数据
//        InputStream is = socket.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
        // 缓冲流提高效率
//        BufferedReader br = new BufferedReader(isr);

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }

        // 4.释放资源
        socket.close();
        ss.close();

    }
}
