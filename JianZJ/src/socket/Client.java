package socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            // 创建Socket连接服务器
            Socket socket = new Socket("localhost", 12345);

            // 获取输出流，发送消息到服务器
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String s = sc.nextLine();
            writer.println(s);

            // 获取输入流，接收服务器响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = reader.readLine();
            System.out.println("服务器响应: " + serverResponse);

            // 关闭资源
            writer.close();
            reader.close();
            socket.close();
            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
