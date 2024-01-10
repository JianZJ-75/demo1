package farserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FarClient {
    public static void main(String[] args) {
        try {
            // 创建Socket，指定服务器地址和端口
            Socket socket = new Socket("服务器IP地址", 8888);

            // 获取输出流，向服务器发送数据
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, Server!");

            // 关闭流和Socket
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
