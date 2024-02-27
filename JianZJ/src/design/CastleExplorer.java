package design;

/**
 * @Author 22798
 * @Date 2024/2/27 23:02
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

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
        // Randomly generate castle walls
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = random.nextBoolean() ? '#' : '-';
            }
        }
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Castle Explorer");
        setSize(cols * 30, rows * 30);

        // Initialize grid cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                CellPanel cellPanel = new CellPanel(i, j);
                cellPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cellPanel.setBackground(cells[i][j] == '#' ? Color.BLACK : Color.WHITE);
                gridPanel.add(cellPanel);
            }
        }

        // Add buttons
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> calculate());

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clear());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        // Add components to frame
        add(gridPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Custom panel for each grid cell with mouse listener
    private class CellPanel extends JPanel {
        private final int row;
        private final int col;

        public CellPanel(int row, int col) {
            this.row = row;
            this.col = col;
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        toggleCell(row, col);
                    } else if (e.getClickCount() == 2) {
                        switchCell(row, col);
                    }
                }
            });
        }
    }

    // Toggle cell between wall and empty space
    private void toggleCell(int row, int col) {
        cells[row][col] = cells[row][col] == '#' ? '-' : '#';
        gridPanel.getComponent(row * cols + col).setBackground(cells[row][col] == '#' ? Color.BLACK : Color.WHITE);
    }

    // Switch cell between wall and empty space on double click
    private void switchCell(int row, int col) {
        cells[row][col] = cells[row][col] == '#' ? '-' : '#';
        gridPanel.getComponent(row * cols + col).setBackground(cells[row][col] == '#' ? Color.BLACK : Color.WHITE);
    }

    // Explore the castle to find rooms
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

    // Find all rooms in the castle
    private void findRooms() {
        visited.clear();
        rooms.clear();
        maxRoomSize = 0;

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

    // Highlight rooms on the grid
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

    // Calculate number of rooms and max room size
    private void calculate() {
        findRooms();
        highlightRooms();
        JOptionPane.showMessageDialog(null, "Number of rooms: " + rooms.size() + "\nLargest room size: " + maxRoomSize);
    }

    // Clear all walls from the castle
    private void clear() {
        initializeCells(); // Reinitialize cells with random walls
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gridPanel.getComponent(i * cols + j).setBackground(cells[i][j] == '#' ? Color.BLACK : Color.WHITE);
            }
        }
    }

    public static void main(String[] args) {
        int rows = Integer.parseInt(JOptionPane.showInputDialog("Enter number of rows: "));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("Enter number of cols: "));

        SwingUtilities.invokeLater(() -> new CastleExplorer(rows, cols).setVisible(true));
    }
}
