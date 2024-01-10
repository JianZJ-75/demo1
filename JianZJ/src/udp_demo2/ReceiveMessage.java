package udp_demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Objects;

/**
 * @Author: JianZJ
 * @Date: 2024/1/8 0:22
 */
public class ReceiveMessage {
    public static void main(String[] args) throws IOException {
        // 创建对象
        DatagramSocket ds = new DatagramSocket(1024);
        // 接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        while (true) {
            ds.receive(dp);
            // 解析数据
            byte[] data = dp.getData();
            int len = dp.getLength();
            String ip = dp.getAddress().getHostAddress();
            System.out.println(ip + ":" + new String(data, 0, len));
        }
    }
}
