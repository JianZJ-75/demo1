package design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/3/1 0:48
 */
public class Castle {
    // 行
    private int rows;
    // 列
    private int lines;
    // 存总房间数
    private int quantity;
    // 存最大房间大小
    private int max_size = 1;
    // 每个房间大小
    private int[] size;
    private int width = 750;
    private int height = 750;
    private int base_size = 50;
    private int base_interval = 10;
    private int panel_width;
    private int panel_height;
    private List<MyJPanel> panelList;

    // 获取行的值
    public void getRows() {
        int cnt = 0;
        while (!(this.rows >= 1 && this.rows <= 50)) {
            if (cnt > 0) {
                JOptionPane.showMessageDialog(null, "Enter invalid, please re-enter!");
            }
            cnt++;
            this.rows = Integer.parseInt(JOptionPane.showInputDialog("Enter number of rows: (1 ~ 50)"));
        }
    }

    // 获取列的值
    public void getLines() {
        int cnt = 0;
        while (!(this.lines >= 1 && this.lines <= 50)) {
            if (cnt > 0) {
                JOptionPane.showMessageDialog(null, "Enter invalid, please re-enter!");
            }
            cnt++;
            this.lines = Integer.parseInt(JOptionPane.showInputDialog("Enter number of lines: (1 ~ 50)"));
        }
    }

    public void load() {
        // 获取行与列的值
        getRows();
        getLines();
        init();
        new MyJFrame("Castle problem");
    }

    // 初始化
    public void init() {
        // 初始房间数量
        quantity = rows * lines;
        size = new int[quantity + 1];
        panelList = new ArrayList<>();
    }

    public static void main(String[] args) {
        // 启动
        new Castle().load();
    }

    // 主窗口
    class MyJFrame extends JFrame {

        public MyJFrame(String title) {
            super(title);
            calc();

            Container container = getContentPane();
            container.setLayout(null);

            // 面板
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();

            // 按钮
            JButton button = new JButton("compute");
            // 监听鼠标
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // 处理
                    changeColor();
                    // 弹窗
                    JOptionPane.showMessageDialog(null, "Number of rooms: " + quantity + "\nLargest room size: " + max_size);
                }
            });

            // 面板设置
            // 面板1
            panel1.setBackground(Color.BLACK);
            panel1.setBounds(0, 0, panel_width, panel_height);
            panel1.setLayout(null);

            // 面板2
            panel2.setBackground(Color.BLACK);
            panel2.setBounds(base_interval, base_interval, panel_width - 2 * base_interval, panel_height - 2 * base_interval);
            panel2.setLayout(null);
            // 添加房间面板
            addRoom(panel2);

            // 面板3
            panel3.add(button);
            panel3.setBounds(0, panel_height, panel_width, 40);

            panel1.add(panel2);

            container.add(panel1);
            container.add(panel3);

            setBounds(0, 0, width, height);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);
        }

        // 改色
        public void changeColor() {
            for (var i : panelList) {
                i.setBackground(Color.YELLOW);
            }
        }

        // 添加房间
        public void addRoom(JPanel panel2) {
            int x = 0, y = 0, idx = 0;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= lines; j++) {
                    MyJPanel panel = new MyJPanel(++idx);
                    panel.setBounds(x, y, base_size, base_size);
                    panel2.add(panel);
                    panelList.add(panel);
                    x += base_size + base_interval;
                }
                x = 0;
                y += base_size + base_interval;
            }
        }

        // 计算主窗口大小
        public void calc() {
            if (!(base_size * rows + (rows + 1) * base_interval <= height && base_size * lines + (lines + 1) * base_interval <= width)) {
                // 计算能容下的最大大小
                base_interval = Math.min(height / (rows * 5 + rows + 1), width / (lines * 5 + lines + 1));
                base_size = (height - base_interval) / rows - base_interval;
            }
            height = base_size * rows + (rows + 1) * base_interval;
            width = base_size * lines + (lines + 1) * base_interval;
            // 计算主面板大小
            panel_height = height;
            panel_width = width;
            // 上30遮挡，下40按钮
            height += 70;
            // 左右遮挡7
            width += 14;
        }
    }

    class MyJButton extends JButton {
        public MyJPanel myJPanel1;
        public MyJPanel myJPanel2;

        public MyJButton(MyJPanel myJPanel1, MyJPanel myJPanel2) {
            this.myJPanel1 = myJPanel1;
            this.myJPanel2 = myJPanel2;
        }
    }

    class MyJPanel extends JPanel {
        // 面板所对应的房间
        public int id;

        public MyJPanel(int id) {
            this.id = id;
            setBackground(Color.WHITE);
            setSize(base_size, base_size);
        }
    }
}
