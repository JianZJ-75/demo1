package test.test3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author JianZJ
 * @Date 2024/6/20 21:25
 */
public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1024);

        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        while (true) {
            ds.receive(dp);
            byte[] data = dp.getData();
            int len = dp.getLength();
            InetAddress address = dp.getAddress();
            int port = dp.getPort();
            System.out.println(address + "@" + port + " : " + new String(data, 0, len));
        }

    }
}