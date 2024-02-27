package gui.com.jian.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Objects;

/**
 * @Author 22798
 * @Date 2024/2/28 2:01
 */
public class TestActionTwo {
    public static void main(String[] args) {
        // 两个按钮，实现同一个监听
        // 开始 停止
        Frame frame = new Frame("开始-停止");
        Button button1 = new Button("start");
        Button button2 = new Button("stop");

        // 可以显示的定义触发会返回的命令，如果不显示定义，则会走默认的值！
        // 可以多个按钮只写一个监听类
        button2.setActionCommand("stop2");

        MyMonitor myMonitor = new MyMonitor();
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);

        frame.add(button1, BorderLayout.NORTH);
        frame.add(button2, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }
}

class MyMonitor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // e.getActionCommand()获得按钮的信息
        if (Objects.equals(e.getActionCommand(), "start"))
            System.out.println("hello!");
        else if (Objects.equals(e.getActionCommand(), "stop2"))
            System.exit(0);
    }
}