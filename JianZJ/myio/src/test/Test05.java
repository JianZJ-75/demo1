package test;

import java.io.*;

/**
 * @Author JianZJ
 * @Date 2024/4/10 16:34
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        /*
        * 四种方式拷贝文件, 并统计各自用时
        * */

        long start = System.currentTimeMillis();
        
//        method1();
        method2();
        method3();
        method4();
        
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0 + "s");

    }

    private static void method4() throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\OBS\\2023-12-27 23-11-20.mkv"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\OBS\\copy\\copy4.mkv"));
        byte[] bytes = new byte[8192];
        int len;
        while((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
        long end = System.currentTimeMillis();
        System.out.println("no.4 " + (end - start) / 1000.0 + "s");
    }

    private static void method3() throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\OBS\\2023-12-27 23-11-20.mkv"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\OBS\\copy\\copy3.mkv"));
        int b;
        while((b = bis.read()) != -1) {
            bos.write(b);
        }
        bos.close();
        bis.close();
        long end = System.currentTimeMillis();
        System.out.println("no.3 " + (end - start) / 1000.0 + "s");
    }

    private static void method2() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("E:\\OBS\\2023-12-27 23-11-20.mkv");
        FileOutputStream fos = new FileOutputStream("E:\\OBS\\copy\\copy2.mkv");
        byte[] bytes = new byte[8192];
        int len;
        while((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println("no.2 " + (end - start) / 1000.0 + "s");
    }

    private static void method1() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("E:\\OBS\\2023-12-27 23-11-20.mkv");
        FileOutputStream fos = new FileOutputStream("E:\\OBS\\copy\\copy1.mkv");
        int b;
        while((b = fis.read()) != -1) {
            fos.write(b);
        }
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println("no.1 " + (end - start) / 1000.0 + "s");
    }
}
