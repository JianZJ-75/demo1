package test.test7;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author JianZJ
 * @Date 2024/6/21 21:38
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 1024);
        OutputStream os = socket.getOutputStream();
        String str = sc.nextLine();
        while (!"886".equals(str)) {
            os.write((str + "\n").getBytes());
            os.flush();
            str = sc.nextLine();
        }
        os.close();
        socket.close();
    }
}