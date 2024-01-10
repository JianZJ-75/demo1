package farserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class FarServer {
    public static void main(String[] args) {
        try {
            // 创建服务器Socket，监听指定端口
            ServerSocket serverSocket = new ServerSocket(8888);

            // 等待客户端的连接
            System.out.println("等待客户端连接...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端连接成功！");

            // 通过Socket获取输入流，接收客户端发送的数据
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            for (int i = 1; i <= 10; i++) {
                String message = in.readLine();
                System.out.println("收到客户端的消息：" + message);
            }
            // 关闭流和Socket
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
