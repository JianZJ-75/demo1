package test.test6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/6/21 21:12
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1024);
        Socket socket = ss.accept();

    }
}