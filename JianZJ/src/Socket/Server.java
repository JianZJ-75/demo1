package Socket;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // 创建ServerSocket，监听指定端口
            ServerSocket serverSocket = new ServerSocket(12345);

            // 等待客户端连接
            System.out.println("等待客户端连接...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端连接成功!");

            // 获取输入流，接收客户端消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String clientMessage = reader.readLine();
            System.out.println("客户端消息: " + clientMessage);

            // 发送响应消息到客户端
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            writer.println("服务器已接收到消息");

            // 关闭资源
            writer.close();
            reader.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
