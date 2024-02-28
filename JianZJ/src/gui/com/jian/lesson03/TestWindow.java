package gui.com.jian.lesson03;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author JianZJ
 * @Date 2024/2/29 2:11
 */
public class TestWindow {
    public static void main(String[] args) {
        new WindowFrame();
    }
}

class WindowFrame extends Frame {
    public WindowFrame() {
        setBackground(Color.BLACK);
        setBounds(100, 100, 200, 200);
        setVisible(true);
//        addWindowListener(new MyWindowListener());
        this.addWindowListener(
                // 匿名内部类
                new WindowAdapter() {
                    // 关闭
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("windowClosing");
                        System.exit(0);
                    }

                    // 激活
                    @Override
                    public void windowActivated(WindowEvent e) {
                        WindowFrame windowFrame = (WindowFrame) e.getSource();
                        windowFrame.setTitle("被激活了");
                        System.out.println("windowActivated");
                    }
                }
        );
    }
}
