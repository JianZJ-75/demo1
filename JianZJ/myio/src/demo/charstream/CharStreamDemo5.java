package demo.charstream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author JianZJ
 * @Date 2024/4/9 16:12
 */
public class CharStreamDemo5 {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("src\\IO\\resource\\a.txt", true);

        fw.write("我的室友们个个都是好样的");
        fw.write("不能文也不能武");
        fw.write("个个都是人才");

        fw.flush();

        fw.write("说话又不好听");
        fw.write("没颜还tm是个穷光蛋");
        fw.write("唯一有点用的是快废了的腰子");
        fw.write(97);

        fw.close();

    }
}
