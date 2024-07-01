package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/6/30 8:27
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("web\\image\\75.jpg"));
        fis.close();
    }
}