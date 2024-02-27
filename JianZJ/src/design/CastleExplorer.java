package design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
/**
 * @Author 22798
 * @Date 2024/2/26 22:47
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;

public class CastleExplorer extends JFrame {

    private final int rows;
    private final int cols;
    private final char[][] cells;
    private final JPanel gridPanel;
    private final HashSet<Point> visited;
    private final ArrayList<ArrayList<Point>> rooms;
    private int maxRoomSize;

    public CastleExplorer(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new char[rows][cols];
        this.gridPanel = new JPanel(new GridLayout(rows, cols));
        this.visited = new HashSet<>();
        this.rooms = new ArrayList<>();
        this.maxRoomSize = 0;

        initializeCells();
        initializeUI();
    }

    private void initializeCells() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = '#'; // Initialize all cells with walls
            }
        }
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Castle Explorer");
        setSize(cols * 30, rows * 30);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JPanel cellPanel = new JPanel();
                cellPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cellPanel.setBackground(Color.BLACK);
                gridPanel.add(cellPanel);
            }
        }

        gridPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = e.getX() / 30;
                int row = e.getY() / 30;
                if (cells[row][col] == '#') {
                    cells[row][col] = '-';
                    gridPanel.getComponent(row * cols + col).setBackground(Color.WHITE);
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot remove wall here.");
                }
            }
        });

        add(gridPanel, BorderLayout.CENTER);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> calculate());
        add(calculateButton, BorderLayout.SOUTH);
    }

    private void exploreRoom(int row, int col, ArrayList<Point> room) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return;
        }
        if (visited.contains(new Point(row, col)) || cells[row][col] == '#') {
            return;
        }
        visited.add(new Point(row, col));
        room.add(new Point(row, col));
        maxRoomSize = Math.max(maxRoomSize, room.size());

        exploreRoom(row + 1, col, room);
        exploreRoom(row - 1, col, room);
        exploreRoom(row, col + 1, room);
        exploreRoom(row, col - 1, room);
    }

    private void findRooms() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited.contains(new Point(i, j)) && cells[i][j] != '#') {
                    ArrayList<Point> room = new ArrayList<>();
                    rooms.add(room);
                    exploreRoom(i, j, room);
                }
            }
        }
    }

    private void highlightRooms() {
        Color[] colors = {Color.YELLOW, Color.ORANGE};
        int colorIndex = 0;
        for (ArrayList<Point> room : rooms) {
            for (Point point : room) {
                int row = point.x;
                int col = point.y;
                gridPanel.getComponent(row * cols + col).setBackground(colors[colorIndex % 2]);
            }
            colorIndex++;
        }
    }

    private void calculate() {
        findRooms();
        highlightRooms();
        JOptionPane.showMessageDialog(null, "Number of rooms: " + rooms.size() + "\nLargest room size: " + maxRoomSize);
    }

    public static void main(String[] args) {
        int rows = Integer.parseInt(JOptionPane.showInputDialog("Enter number of rows: "));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("Enter number of cols: "));

        SwingUtilities.invokeLater(() -> new CastleExplorer(rows, cols).setVisible(true));
    }
}
