package udp_demo1;

import java.io.IOException;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Author: JianZJ
 * @Date: 2024/1/9 15:37
 */
public class SendMessage {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 1024;
        while (true) {
            String s = sc.nextLine();
            if (Objects.equals("886", s))
                break;
            byte[] bytes = s.getBytes();
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
            ds.send(dp);
        }
        ds.close();
        sc.close();
    }
}
