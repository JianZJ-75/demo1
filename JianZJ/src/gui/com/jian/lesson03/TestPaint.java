package gui.com.jian.lesson03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author 22798
 * @Date 2024/2/28 23:19
 */
public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame {

    public void loadFrame() {
        setBounds(0, 0, 1920, 1080);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 画笔
    @Override
    public void paint(Graphics g) {
        // 画笔，需要有颜色，画笔可以画画
        g.setColor(Color.RED);
        // 空心
        g.drawOval(100, 100, 300, 200);
        // 实心
        g.fillOval(400, 100, 300, 200);

        g.setColor(Color.GREEN);
        g.fillRect(100, 300, 300, 200);
        // 养成习惯，画笔用完，将它还原到最初的颜色
        g.setColor(Color.BLACK);
    }
}
