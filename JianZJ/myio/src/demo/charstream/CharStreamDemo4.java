package demo.charstream;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/9 15:52
 */
public class CharStreamDemo4 {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("src\\IO\\resource\\b.txt");

        int b1 = fr.read();
        System.out.println(b1);

        int b2 = fr.read();
        System.out.println(b2);

        int b3 = fr.read();
        System.out.println(b3);

        int b4 = fr.read();
        System.out.println(b4);

        fr.close();

    }
}
