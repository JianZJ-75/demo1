package gui.com.jian.lesson03;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author 22798
 * @Date 2024/2/28 23:55
 */
// 鼠标监听事件
public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("画图");
    }
}

class MyFrame extends Frame {
    List<Point> points;

    public MyFrame(String title) {
        super(title);
        setBounds(100, 100, 1000, 800);
        points = new ArrayList<>();
        addMouseListener(new MyMouseListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        // 画画，监听鼠标事件
        for (var i : points) {
            g.setColor(Color.BLACK);
            g.fillOval(i.x, i.y, 5, 5);
        }
    }

    class MyMouseListener extends MouseAdapter {
        // 鼠标 按下、弹起、按住不放

        @Override
        public void mousePressed(MouseEvent e) {
//            MyFrame myFrame = (MyFrame) e.getSource();
            // 这里我们点击的时候，就会在界面上产生一个点！
            // 这个点就是鼠标的点
            // 将点添加到界面上
            points.add(new Point(e.getX(), e.getY()));
            // 每次点击鼠标都需要重新画一遍
            // 刷新
            repaint();
        }
    }
}
