package gui.com.jian.lesson01;

import java.awt.*;

/**
 * @Author 22798
 * @Date 2024/2/27 23:45
 */
public class TestFrame2 {
    public static void main(String[] args) {

        // 展示多个窗口 new
        MyFrame myFrame1 = new MyFrame(100, 100, 200, 200, Color.BLUE);
        MyFrame myFrame2 = new MyFrame(300, 100, 200, 200, Color.YELLOW);
        MyFrame myFrame3 = new MyFrame(100, 300, 200, 200, Color.RED);
        MyFrame myFrame4 = new MyFrame(300, 300, 200, 200, Color.MAGENTA);
    }
}

class MyFrame extends Frame {
    static int id = 0; // 可能存在多个窗口， 我们需要一个计数器

    public MyFrame(int x, int y, int w, int h, Color color) {
        super("MyFrame" + (++id));
        setBackground(color);
        setBounds(x, y, w, h);
        setVisible(true);
    }
}
