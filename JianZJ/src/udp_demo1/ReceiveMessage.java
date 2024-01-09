package udp_demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author: JianZJ
 * @Date: 2024/1/9 15:37
 */
public class ReceiveMessage {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1024);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        while (true) {
            ds.receive(dp);
            byte[] data = dp.getData();
            String ip = dp.getAddress().getHostAddress();
            System.out.println(ip + ":" + new String(data, 0, dp.getLength()));
        }
    }
}
