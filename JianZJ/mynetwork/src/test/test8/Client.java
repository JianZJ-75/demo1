package test.test8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/6/21 22:06
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 1024);
        OutputStream os = socket.getOutputStream();
        String str = "hello";
        os.write(str.getBytes());
        socket.shutdownOutput();
    }
}