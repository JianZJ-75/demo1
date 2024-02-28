package gui.com.jian.lesson03;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @Author JianZJ
 * @Date 2024/2/29 2:27
 */
public class TestKeyListener {
    public static void main(String[] args) {
        new KetFrame();
    }
}

class KetFrame extends Frame {
    public KetFrame() {
        setBounds(1, 2, 300, 400);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            // 键盘按下
            @Override
            public void keyPressed(KeyEvent e) {
                // 获得键盘按下的键是哪一个,当前的码
                int keyCode = e.getKeyCode();
                // 不需要记住这个数值，直接使用静态属性 VK_XXX
                System.out.println(keyCode);
                if (keyCode == KeyEvent.VK_UP) {
                    System.out.println("UP!!!");
                }
                // 根据按下的不同操作，产生不同结果
            }
        });
    }
}
