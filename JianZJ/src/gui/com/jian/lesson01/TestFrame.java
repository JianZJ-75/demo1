package gui.com.jian.lesson01;

import java.awt.*;

/**
 * @Author 22798
 * @Date 2024/2/27 23:31
 */
public class TestFrame {
    public static void main(String[] args) {

        // Frame
        Frame frame = new Frame("我的第一个Java图形界面窗口");

        // 需要设置可见性
        frame.setVisible(true);

        // 设置窗口大小
        frame.setSize(400, 400);

        // 弹出的初始位置
        frame.setLocation(200, 200);

        // 设置背景颜色
        frame.setBackground(new Color(207, 253, 0, 255));

        // 设置大小固定
        frame.setResizable(false);
    }
}
