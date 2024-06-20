package test.test1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author JianZJ
 * @Date 2024/6/20 20:49
 */
public class Demo1 {
    public static void main(String[] args) throws UnknownHostException {
        // 获取IP的对象 一台电脑的对象
        InetAddress address = InetAddress.getByName("CY");
        System.out.println(address);
        System.out.println(InetAddress.getByName("192.168.0.101"));
        // 获取主机名
        System.out.println(address.getHostName());
        // 获取ip
        System.out.println(address.getHostAddress());
    }
}