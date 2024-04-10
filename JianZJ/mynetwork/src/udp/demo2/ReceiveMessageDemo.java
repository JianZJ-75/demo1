package udp.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author JianZJ
 * @Date 2024/3/21 23:17
 */
public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建对象
        DatagramSocket ds = new DatagramSocket(1024);

        // 2.接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        while(true)
        {
            ds.receive(dp);

            // 3.接续数据包
            byte[] data = dp.getData();
            int len = dp.getLength();
            String ip = dp.getAddress().getHostAddress();
            String name = dp.getAddress().getHostName();

            // 4.打印数据
            System.out.println("ip为" + ip + "，主机名为：" + name + "的人，发送了数据：" + new String(data, 0, len));
        }
    }
}
