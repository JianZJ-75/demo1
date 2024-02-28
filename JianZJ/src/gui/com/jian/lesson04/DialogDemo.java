package gui.com.jian.lesson04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author JianZJ
 * @Date 2024/2/29 3:13
 */
// 主窗口
public class DialogDemo extends JFrame {
    public DialogDemo() {
        setVisible(true);
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // JFrame 放东西，容器
        Container container = getContentPane();
        // 绝对布局
        container.setLayout(null);

        // 按钮
        // 创建
        JButton button = new JButton("点击弹出一个对话框");
        button.setBounds(30, 30, 200, 50);

        // 点击这个按钮的时候，弹出一个弹窗
        button.addActionListener(new ActionListener() {
            // 监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹窗
                new MyDialogDemo();
            }
        });

        container.add(button);
    }
    public static void main(String[] args) {
        new DialogDemo();
    }
}

// 弹窗的窗口
class MyDialogDemo extends JDialog {
    public MyDialogDemo() {
        setVisible(true);
        setBounds(100, 100, 500, 500);
        // 弹窗默认可关闭，只需要设置另外3个
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(null);

        JLabel label = new JLabel("op!!!");

        label.setBounds(10, 10, 100, 100);

        container.add(label);
    }
}