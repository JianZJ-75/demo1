package gui.com.jian.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author 22798
 * @Date 2024/2/28 21:06
 */
public class TestCalc {
    public static void main(String[] args) {
        new Calculator().loadFrame();
    }
}

// 计算器类
class Calculator extends Frame {

    // 属性
    TextField num1;
    TextField num2;
    TextField num3;

    // 方法
    public void loadFrame() {
        // 3个文本框
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(20);

        // 1个按钮
        Button button = new Button("=");
        button.addActionListener(new MyCalculatorListener());

        // 1个标签
        Label label = new Label("+");

        // 布局
        setLayout(new FlowLayout());

        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pack();
        setVisible(true);
    }

    // 监听器类
    // 内部类最大的好处，就是可以畅通无阻的访问外部的属性和方法！
    class MyCalculatorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // 1.获得加数与被加数
            // 2.将这个值+法运算后，放到第三个框
            // 3.清除前两个框
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());
            num3.setText("" + (n1 + n2));
            num1.setText("");
            num2.setText("");
        }
    }
}
