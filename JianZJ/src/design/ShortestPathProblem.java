package design;

/**
 * @Author JianZJ
 * @Date 2024/3/6 14:00
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShortestPathProblem {
    // 定义格子的大小
    private static final int CELL_SIZE = 20;
    // 定义速度数组
    private int[][] speeds;
    // 定义起点和终点的坐标
    private int startX, startY, endX, endY;
    // 定义最短时间
    private int shortestTime;

    private JPanel panel;

    public ShortestPathProblem() {
        // 创建图形界面窗口
        JFrame frame = new JFrame("最短时间问题");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // 创建面板
        panel = new JPanel();
        panel.setBounds(0, 0, 600, 600);
        panel.setLayout(null);

        // 添加生成格子和阴影矩形的按钮
        JButton generateBtn = new JButton("随机生成");
        generateBtn.setBounds(10, 10, 100, 30);
        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateGrid();
            }
        });
        panel.add(generateBtn);

        JButton clearBtn = new JButton("手动绘制");
        clearBtn.setBounds(10, 50, 100, 30);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearGrid();
            }
        });
        panel.add(clearBtn);

        // 添加设置速度的滑块
        JSlider speedSlider = new JSlider(10, 1000, 10);
        speedSlider.setPaintTicks(true);
//        speedSlider.addChangeListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setSpeed(speedSlider.getValue());
//            }
//        });
        speedSlider.setBounds(130, 10, 440, 30);
        panel.add(speedSlider);

        // 添加显示最短时间的标签
        JLabel shortestTimeLabel = new JLabel("最短时间: " + shortestTime + " 分钟");
        shortestTimeLabel.setBounds(10, 90, 200, 30);
        panel.add(shortestTimeLabel);

        // 将面板添加到窗口
        frame.add(panel);

        frame.setVisible(true);
    }

    private void generateGrid() {
        // 随机生成格子和阴影矩形
        speeds = new int[60][60];
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                if (Math.random() < 0.3) {
                    speeds[i][j] = 10;
                } else {
                    speeds[i][j] = 1000;
                }
            }
        }

        // 随机生成起点和终点
        startX = (int) (Math.random() * 60);
        startY = (int) (Math.random() * 60);
        endX = (int) (Math.random() * 60);
        endY = (int) (Math.random() * 60);

        // 绘制格子和阴影矩形
        drawGrid();
        drawRects();
    }

    private void clearGrid() {
        // 清空速度数组和最短时间
        speeds = new int[60][60];
        shortestTime = 0;

        // 重绘界面
        drawGrid();
    }

    private void setSpeed(int speed) {
        // 设置所有矩形的速度
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                speeds[i][j] = speed;
            }
        }

        // 重新计算最短时间并更新显示
        shortestTime = calculateShortestTime();
        drawRects();
    }

    private void drawGrid() {
        // 绘制格子
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                if (i == 0 || i == 59 || j == 0 || j == 59) {
                    drawLine(i * CELL_SIZE, j * CELL_SIZE, i * CELL_SIZE + CELL_SIZE, j * CELL_SIZE, Color.BLACK);
                    drawLine(i * CELL_SIZE, j * CELL_SIZE, i * CELL_SIZE, j * CELL_SIZE + CELL_SIZE, Color.BLACK);
                } else {
                    drawLine(i * CELL_SIZE, j * CELL_SIZE, i * CELL_SIZE + CELL_SIZE, j * CELL_SIZE, Color.GRAY);
                    drawLine(i * CELL_SIZE, j * CELL_SIZE, i * CELL_SIZE, j * CELL_SIZE + CELL_SIZE, Color.GRAY);
                }
            }
        }
    }

    private void drawRects() {
        // 绘制阴影矩形
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                if (speeds[i][j] > 10) {
                    drawRectangle(i * CELL_SIZE + 1, j * CELL_SIZE + 1, CELL_SIZE - 2, CELL_SIZE - 2, Color.RED);
                } else if (speeds[i][j] > 0) {
                    drawRectangle(i * CELL_SIZE + 1, j * CELL_SIZE + 1, CELL_SIZE - 2, CELL_SIZE - 2, Color.GREEN);
                }
            }
        }

        // 绘制行驶路线
        drawLine(startX * CELL_SIZE + 1, startY * CELL_SIZE + 1, endX * CELL_SIZE + 1, endY * CELL_SIZE + 1, Color.RED);
    }

    private void drawLine(int x1, int y1, int x2, int y2, Color color) {
        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }

    private void drawRectangle(int x, int y, int width, int height, Color color) {
        Graphics g = panel.getGraphics();
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }

    // 计算最短时间
    private int calculateShortestTime() {
        // 初始化最短时间为无穷大
        int shortestTime = Integer.MAX_VALUE;

        // 使用动态规划计算最短时间
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                if (i == startX && j == startY) {
                    shortestTime = 0;
                } else if (speeds[i][j] <= 10) {
                    shortestTime = Math.min(shortestTime, shortestTime + 10);
                } else {
                    shortestTime = Math.min(shortestTime, shortestTime + speeds[i][j]);
                }
            }
        }

        return shortestTime;
    }

    public static void main(String[] args) {
        // 创建最短路径问题对象并启动图形界面
        ShortestPathProblem shortestPathProblem = new ShortestPathProblem();
        System.out.println("shortestPathProblem.calculateShortestTime() = " + shortestPathProblem.calculateShortestTime());
    }
}
