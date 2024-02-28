package gui.com.jian.lesson04;

import javax.swing.*;
import java.awt.*;

/**
 * @Author JianZJ
 * @Date 2024/2/29 2:36
 */
public class JFrameDemo {

    // init() 初始化
    public void init() {
        // 顶级窗口
        JFrame jf = new JFrame("这是一个JFrame窗口");
        jf.setVisible(true);
        jf.setBounds(100, 100, 200, 200);

        // 设置文字 JLabel
        // 让文本标签居中
        JLabel label = new JLabel("Stop!!!", SwingConstants.CENTER);

        // JLabel默认透明，若要设置颜色，需要先将其设置为不透明
        label.setOpaque(true);
        label.setBackground(Color.RED);

        jf.add(label);

        // 设置文本标签居中 设置水平对齐
//        label.setHorizontalAlignment(SwingConstants.CENTER);

        // 容器实例化
        jf.getContentPane().setBackground(Color.CYAN);

        // 关闭事件
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // 建立一个窗口
        new JFrameDemo().init();
    }
}
