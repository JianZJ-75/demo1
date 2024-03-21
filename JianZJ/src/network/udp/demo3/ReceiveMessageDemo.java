package network.udp.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author JianZJ
 * @Date 2024/3/21 23:34
 */
public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建MulticastSocket对象
        MulticastSocket ms = new MulticastSocket(1024);

        // 2.将当前本机，添加到224.0.0.1这一组当中
        InetAddress address = InetAddress.getByName("224.0.0.1");
        ms.joinGroup(address);

        // 3.创建DatagramPacket数据包对象
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        // 4.接收数据
        ms.receive(dp);

        // 5.解析数据
        byte[] data = dp.getData();
        int len = dp.getLength();
        String ip = dp.getAddress().getHostAddress();
        String name = dp.getAddress().getHostName();

        System.out.println("ip为" + ip + "，主机名为：" + name + "的人，发送了数据：" + new String(data, 0, len));

        // 6.释放资源
        ms.close();
    }
}
