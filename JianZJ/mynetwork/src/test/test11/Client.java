package test.test11;

import java.io.*;
import java.net.Socket;

/**
 * @Author JianZJ
 * @Date 2024/6/22 2:57
 */

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10011);
        OutputStream os = socket.getOutputStream();
        File file = new File("mynetwork\\src\\resource\\test\\namelist.txt");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1) {
            bos.write(buf, 0, len);
        }
        bos.flush();
        socket.shutdownOutput();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        bis.close();
        socket.close();
    }
}
