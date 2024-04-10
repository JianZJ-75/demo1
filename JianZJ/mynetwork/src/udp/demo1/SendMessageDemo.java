package udp.demo1;

import java.io.IOException;
import java.net.*;

/**
 * @Author JianZJ
 * @Date 2024/3/21 22:55
 */
public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        // 发送数据

        // 1.创建DatagramSocket对象（快递公司）
        // 细节：
        // 绑定端口：以后我们就是通过这个端口往外发送
        // 有参：指定端口号进行绑定
        DatagramSocket ds = new DatagramSocket();

        // 2.打包数据
        String str = "hello!";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 1024;

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

        // 3.发送数据
        ds.send(dp);

        // 4.释放资源
        ds.close();
    }
}
