package gui.com.jian.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author 22798
 * @Date 2024/2/28 2:09
 */
public class TestText01 {
    public static void main(String[] args) {
        // 启动！
        new MyFrame();
    }
}

class MyFrame extends Frame {
    public MyFrame() {
        TextField textField = new TextField();
        add(textField);
        
        // 监听这个文本框输入的文字
        MyMonitor2 myMonitor2 = new MyMonitor2();
        // 按下enter就会触发这个输入框的事件
        textField.addActionListener(myMonitor2);

        // 设置替换的编码
        textField.setEchoChar('*');

        setVisible(true);
        pack();
    }
}

class MyMonitor2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获得一些资源，返回一个对象
        TextField field = (TextField) e.getSource();
        // 获得输入框的文本
        System.out.println(field.getText());
        // 输入完恢复空
        field.setText("");
    }
}
