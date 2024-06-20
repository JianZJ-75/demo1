package test.test3;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @Author JianZJ
 * @Date 2024/6/20 21:25
 */
public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        InetAddress address = InetAddress.getByName("CY");
        int port = 1024;
        while (!"886".equals(message)) {
            byte[] buf = message.getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length, address, port);
            ds.send(dp);
            message = sc.nextLine();
        }
        ds.close();

    }
}