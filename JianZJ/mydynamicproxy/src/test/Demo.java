package test;

/**
 * @Author JianZJ
 * @Date 2024/6/22 18:11
 */

public class Demo {
    public static void main(String[] args) {
        // 获取代理对象
        BigStar bigStar = new BigStar("猴鸡坤");
        Star proxy = ProxyUtil.creatProxy(bigStar);

        // 调用方法
        String res = proxy.sing("吗喽之歌");
        System.out.println(res);

        proxy.dance();
    }
}
