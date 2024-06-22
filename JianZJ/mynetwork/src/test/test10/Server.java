package test.test10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * @Author JianZJ
 * @Date 2024/6/22 2:44
 */

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);
        while (true) {
            Socket socket = ss.accept();
            if (socket == null)
                continue;
            new Thread(new MyRunnable(socket)).start();
        }
    }
}
