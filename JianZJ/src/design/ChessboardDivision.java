package design;

/**
 * @Author JianZJ
 * @Date 2024/3/4 21:49
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessboardDivision extends JFrame implements ActionListener {
    private JPanel chessboardPanel;
    private JButton startButton, nextButton;
    private int[][] chessboard = new int[8][8];
    private int[][] divisionLines = new int[7][2];
    private JLabel meanLabel, varianceLabel;
    private int currentDivision = 0;
    private int targetBlocks;

    public ChessboardDivision() {
        setTitle("Chessboard Division");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chessboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawChessboard(g);
            }
        };
        add(chessboardPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        startButton = new JButton("Start");
        nextButton = new JButton("Next");
        startButton.addActionListener(this);
        nextButton.addActionListener(this);
        buttonPanel.add(startButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        JPanel statPanel = new JPanel();
        meanLabel = new JLabel("Mean: ");
        varianceLabel = new JLabel("Variance: ");
        statPanel.add(meanLabel);
        statPanel.add(varianceLabel);
        add(statPanel, BorderLayout.NORTH);
    }

    private void drawChessboard(Graphics g) {
        int width = chessboardPanel.getWidth();
        int height = chessboardPanel.getHeight();
        int cellWidth = width / 8;
        int cellHeight = height / 8;

        // Draw chessboard cells
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(chessboard[i][j]), j * cellWidth + cellWidth / 2, i * cellHeight + cellHeight / 2);
            }
        }

        // Draw division lines
        g.setColor(Color.RED);
        for (int i = 0; i < currentDivision; i++) {
            if (divisionLines[i][0] == 0) {
                g.fillRect(divisionLines[i][1] * cellWidth - 1, 0, 3, height);
            } else {
                g.fillRect(0, divisionLines[i][1] * cellHeight - 1, width, 3);
            }
        }
    }

    private boolean isValidDivision(int index, int axis, int position) {
        for (int i = 0; i < index; i++) {
            if (divisionLines[i][0] == axis && divisionLines[i][1] == position) {
                return false;
            }
        }
        return true;
    }

    private void divideChessboard() {
        if (currentDivision < targetBlocks - 1) {
            int index = currentDivision++;
            int axis = index % 2;
            int position = (int) (Math.random() * 6) + 1; // 避免切割线位于棋盘边缘
            if (isValidDivision(index, axis, position)) {
                divisionLines[index][0] = axis;
                divisionLines[index][1] = position;
            }
        }
    }

    private void calculateStatistics() {
        // Calculate mean and variance
        int total = 0;
        for (int[] row : chessboard) {
            for (int value : row) {
                total += value;
            }
        }
        double mean = (double) total / (8 * 8);
        meanLabel.setText("Mean: " + mean);

        double variance = 0;
        for (int[] row : chessboard) {
            for (int value : row) {
                variance += Math.pow(value - mean, 2);
            }
        }
        variance /= (8 * 8);
        varianceLabel.setText("Variance: " + variance);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // Initialize chessboard with random values
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    chessboard[i][j] = (int) (Math.random() * 10);
                }
            }
            // Reset division lines
            divisionLines = new int[7][2];
            currentDivision = 0;
            meanLabel.setText("Mean: ");
            varianceLabel.setText("Variance: ");
            repaint();

            // Prompt user for target number of blocks
            String input = JOptionPane.showInputDialog(this, "Enter the target number of blocks (n):");
            if (input != null) {
                try {
                    targetBlocks = Integer.parseInt(input);
                    targetBlocks /= 2;
                    targetBlocks++;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input! Please enter a valid integer.");
                }
            }
        } else if (e.getSource() == nextButton) {
            divideChessboard();
            calculateStatistics();
            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessboardDivision chessboardDivision = new ChessboardDivision();
            chessboardDivision.setVisible(true);
        });
    }
}
