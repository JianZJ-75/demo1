package gui.com.jian.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author 22798
 * @Date 2024/2/28 1:45
 */
public class TestActionEvent {
    public static void main(String[] args) {
        // 按下按钮，触发一些事件
        Frame frame = new Frame();
        Button button = new Button("btn1");

        // 因为addActionListener()需要一个ActionListener，所以我们需要构造一个ActionListener
        MyActionListener myActionListener = new MyActionListener();
        button.addActionListener(myActionListener);

        frame.add(button, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        windowClose(frame);
    }

    // 关闭窗体的事件
    private static void windowClose(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

// 事件监听
class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("yes");
    }
}