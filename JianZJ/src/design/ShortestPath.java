package design;

/**
 * @Author JianZJ
 * @Date 2024/3/6 14:00
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate that = (Coordinate) obj;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Cell {
    int time;

    Cell(int time) {
        this.time = time;
    }
}

public class ShortestPath extends JFrame {
    private static Integer cellSize = 40;
    public static Integer rows = 16;
    public static Integer cols = 9;

    public static Integer defaultSpeed = 10;
    public static Integer tiSpeed = 10;
    public static Integer shadowAreaNums = 3;
    private Map<Coordinate, Cell> grid;
    private static Coordinate pointA;
    private static Coordinate pointB;

    private static List<List<Coordinate>> allPaths = new ArrayList<>();
    private static Set<Set<Coordinate>> shadowCoordinates = new HashSet<>();
    private static Set<Coordinate> shadowPoints = new HashSet<>();


    public static void main(String[] args) {
        pointA = new Coordinate(1, 6);
        pointB = new Coordinate(15, 3);
        //线创建网格区 初始化阴影部分
        Map<Coordinate, Cell> grid = initializeGrid();
        ShortestPath mapVisualization = new ShortestPath(grid);
        mapVisualization.setVisible(true);
        mapVisualization.createUI();
    }

    private void createUI() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("tiSpeed:");
        JTextField textField = new JTextField(10);
        JButton startButton = new JButton("开始绘画");
        //监听按钮事件
        startButton.addActionListener(e -> {
            try {
                tiSpeed = Integer.parseInt(textField.getText());
                repaint();
                resetShadowTimes(tiSpeed);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "请输入有效的整数值作为 tiSpeed。", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(startButton);
        add(panel, BorderLayout.PAGE_END);  // 修改这一行

//        add(panel, BorderLayout.SOUTH);
        System.out.println("UI created.");
    }

    private void resetShadowTimes(Integer tiSpeed) {
        System.out.println("阴影部分区域开始重置");
        for (Coordinate shadowPoint : shadowPoints) {
            System.out.println("("+shadowPoint.x+","+shadowPoint.y+")");
            grid.put(shadowPoint, new Cell(tiSpeed));
        }
        System.out.println("阴影部分区域时间已经重置，当前经过阴影区域的Ti为：" + tiSpeed);
    }

    // 添加新的方法，用于绘制最短路径
    private void drawShortestPath(Graphics g, int xOffset, int yOffset, List<Coordinate> shortestPath) {

        if (shortestPath != null && shortestPath.size() > 1) {
            g.setColor(Color.GREEN); // 绿色表示最短路径
            drawPath(g, shortestPath, xOffset, yOffset);
        }
    }

    public ShortestPath(Map<Coordinate, Cell> grid) {
        this.grid = grid;
        setTitle("Map Visualization");
        setSize(rows * cellSize * 2, cols * cellSize * 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 计算地图的左上角坐标，使其居中显示
        int mapWidth = rows * cellSize;
        int mapHeight = cols * cellSize;
        int xOffset = (getWidth() - mapWidth) / 2;
        int yOffset = (getHeight() - mapHeight) / 2;

        // 绘制地图
        for (Map.Entry<Coordinate, Cell> entry : grid.entrySet()) {
            Coordinate coord = entry.getKey();
            int x = coord.x * cellSize + xOffset;
            int y = coord.y * cellSize + yOffset;
            int time = entry.getValue().time;


            g.setColor(Color.WHITE); // 非阴影区域为白色


            g.fillRect(x, y, cellSize, cellSize);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, cellSize, cellSize);
        }
        drawShadowAreas(g, xOffset, yOffset);


        // 标记点A和点B
        g.setColor(Color.RED); // 红色表示标记点
        int xA = pointA.x * cellSize + xOffset;
        int yA = pointA.y * cellSize + yOffset;
        g.fillOval(xA - cellSize / 4, yA - cellSize / 4, cellSize / 2, cellSize / 2);

        g.setColor(Color.BLUE); // 蓝色表示标记点
        int xB = pointB.x * cellSize + xOffset;
        int yB = pointB.y * cellSize + yOffset;
        g.fillOval(xB - cellSize / 4, yB - cellSize / 4, cellSize / 2, cellSize / 2);

        // 绘制坐标轴下标
        g.setColor(Color.BLACK); // 黑色表示下标
        for (int i = 0; i <= rows; i++) {
            int xIndex = i * cellSize + xOffset;
            int yIndex = yOffset;
            g.drawString(String.valueOf(i), xIndex, yIndex);
        }

        for (int j = 0; j <= cols; j++) {
            int xIndex = xOffset;
            int yIndex = j * cellSize + yOffset;
            g.drawString(String.valueOf(j), xIndex, yIndex);
        }
        if (tiSpeed > 10) {
            System.out.println("当前经过阴影区域的Ti为：" + tiSpeed);
            dijkstraAlgorithm(g, xOffset, yOffset, pointA, pointB, grid);

        }

    }


    private void drawShadowAreas(Graphics g, int xOffset, int yOffset) {
        // 遍历 shadowCoordinates 中所有坐标
        for (Set<Coordinate> shadowCoordinate : shadowCoordinates) {
            for (Coordinate coord : shadowCoordinate) {
                // 计算格子左上角的绘制坐标
                int x = coord.x * cellSize + xOffset;
                int y = coord.y * cellSize + yOffset;
                Coordinate coordX = new Coordinate(coord.x + 1, coord.y + 1);
                // 在有效范围内绘制灰色格子
                if (shadowCoordinate.contains(coord) && shadowCoordinate.contains(coordX)) {
                    g.setColor(Color.GRAY); // 设置阴影区域颜色
                    g.fillRect(x, y, cellSize, cellSize); // 绘制阴影区域
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, cellSize, cellSize); // 绘制格子边界
                }
            }
        }

    }


    // 初始化网格区域（每次运行程序只生成一次)
    private static Map<Coordinate, Cell> initializeGrid() {
        Map<Coordinate, Cell> grid = new HashMap<>();

        // 绘制网格
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid.put(new Coordinate(i, j), new Cell(defaultSpeed)); // 默认时间为10分钟
            }
        }
        // 随机生成多片不重叠的阴影区域
        randomCreateShadowArea(grid);
        return grid;
    }

    private static void randomCreateShadowArea(Map<Coordinate, Cell> grid) {
        // 清空阴影区域和阴影点
        shadowCoordinates.clear();
        shadowPoints.clear();
        // 随机生成多片不重叠的阴影区域
        for (int i = 0; i < shadowAreaNums; i++) {
            int x1, y1, x2, y2;
            // 保证生成的阴影区域不重叠
            do {
                x1 = getRandomCoordinate(0, rows - 1);
                y1 = getRandomCoordinate(0, cols - 1);
                x2 = getRandomCoordinate(x1, rows - 1);
                y2 = getRandomCoordinate(y1, cols - 1);
            } while (isOverlap(grid, x1, y1, x2, y2));
            Set<Coordinate> coordinates = new HashSet<>();
            for (int i1 = x1; i1 <= x2; i1++) {
                for (int j = y1; j <= y2; j++) {
//                    grid.put(new Coordinate(i1, j), new Cell(tiSpeed));
                    coordinates.add(new Coordinate(i1, j));
                }
            }
            shadowCoordinates.add(coordinates);
            shadowPoints.addAll(coordinates);
            System.out.println("阴影区域 " + (i + 1) + " 的坐标：(" + x1 + ", " + y1 + ") -> (" + x2 + ", " + y2 + ")");
        }
    }


    // 判断随机生成的阴影点是否已经存在
    private static boolean isOverlap(Map<Coordinate, Cell> grid, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (shadowPoints.contains(new Coordinate(i, j)) || x1 == x2 || y1 == y2|| x2-x1<=1||y2-y1<=1) {
                    return true; // 如果该坐标已在阴影区域内，返回 true
                }
            }
        }
        return false; // 没有重叠的情况
    }


    // 找出当前点的四个邻居
    private static List<Coordinate> getNeighbors(Coordinate coord, Map<Coordinate, Cell> grid) {
        List<Coordinate> neighbors = new ArrayList<>();

        int x = coord.x;
        int y = coord.y;

        // 添加上下左右四个方向的邻居点
        if (isValidCoordinate(x - 1, y, grid)) {
            neighbors.add(new Coordinate(x - 1, y));
        }
        if (isValidCoordinate(x + 1, y, grid)) {
            neighbors.add(new Coordinate(x + 1, y));
        }
        if (isValidCoordinate(x, y - 1, grid)) {
            neighbors.add(new Coordinate(x, y - 1));
        }
        if (isValidCoordinate(x, y + 1, grid)) {
            neighbors.add(new Coordinate(x, y + 1));
        }

        return neighbors;
    }

    private static boolean isValidCoordinate(int x, int y, Map<Coordinate, Cell> grid) {
        return x >= 0 && x < rows && y >= 0 && y < cols && grid.containsKey(new Coordinate(x, y));
    }

    private static int getRandomCoordinate(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    // 修改 dijkstraAlgorithm 方法
    private void dijkstraAlgorithm(Graphics g, int xOffset, int yOffset, Coordinate start, Coordinate end, Map<Coordinate, Cell> grid) {

        Map<Coordinate, Integer> distance = new HashMap<>();
        Map<Coordinate, Coordinate> parent = new HashMap<>();

        PriorityQueue<Coordinate> pq = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        distance.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Coordinate current = pq.poll();

            for (Coordinate neighbor : getNeighbors(current, grid)) {
                int newDist = distance.get(current) + getWeight(current, neighbor, grid);
                if (newDist < distance.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distance.put(neighbor, newDist);
                    parent.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }

        // 保存所有路径
        allPaths.clear();
        for (Coordinate coord : grid.keySet()) {
            if (!coord.equals(start)) {
                List<Coordinate> path = new ArrayList<>();
                Coordinate current = coord;
                while (current != null) {
                    path.add(current);
                    current = parent.get(current);
                }
                Collections.reverse(path);
                allPaths.add(path);
            }
        }
        // 获取最短路径
        List<Coordinate> shortestPath = getShortestPath(start, end, grid);
        //a->b
        drawShortestPath(g, xOffset, yOffset, shortestPath);

    }

    private static void printShortestPath(List<Coordinate> path, Map<Coordinate, Cell> grid) {

        for (int i = 0; i < path.size()-1 ; i++) {
            Coordinate point = path.get(i);
            Coordinate nextPoint = path.get(i + 1);
            int weight = getWeight(point, nextPoint, grid);

            System.out.println("（"+ point.x + ", " + point.y + ")->"+ nextPoint.x + ", " + nextPoint.y + ")，当前时间：" + weight);
        }
        System.out.println();
        System.out.println("最短路径坐标和时间：" + getWeightOfPath(path, grid));
    }

    // 添加新方法 getWeightOfPath
    private static int getWeightOfPath(List<Coordinate> path, Map<Coordinate, Cell> grid) {
        int weight = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Coordinate point = path.get(i);
            Coordinate nextPoint = path.get(i + 1);
            weight += getWeight(point, nextPoint, grid);
        }
        return weight;
    }

    // 添加一个新的 getShortestPath 方法
    private List<Coordinate> getShortestPath(Coordinate start, Coordinate end, Map<Coordinate, Cell> grid) {
        Map<Coordinate, Integer> distance = new HashMap<>();
        Map<Coordinate, Coordinate> parent = new HashMap<>();

        PriorityQueue<Coordinate> pq = new PriorityQueue<>(Comparator.comparingInt(distance::get));
        distance.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            Coordinate current = pq.poll();

            if (current.equals(end)) {
                List<Coordinate> path = new ArrayList<>();
                while (current != null) {
                    path.add(current);
                    current = parent.get(current);
                }
                Collections.reverse(path);
                //打印
                printShortestPath(path, grid);
                return path;
            }

            for (Coordinate neighbor : getNeighbors(current, grid)) {
                int newDist = distance.get(current) + getWeight(current, neighbor, grid);
                if (newDist < distance.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distance.put(neighbor, newDist);
                    parent.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }

        return null;
        // 打印最短路径坐标和距离

    }

    // 修改 drawPath 方法
    private static void drawPath(Graphics g, List<Coordinate> path, int xOffset, int yOffset) {
        for (int i = 0; i < path.size() - 1; i++) {
            Coordinate point = path.get(i);
            Coordinate nextPoint = path.get(i + 1);
            int x1 = point.x * cellSize + xOffset;
            int y1 = point.y * cellSize + yOffset;
            int x2 = nextPoint.x * cellSize + xOffset;
            int y2 = nextPoint.y * cellSize + yOffset;
            g.drawLine(x1, y1, x2, y2);
        }
    }

    // 修改 getWeight 方法
    private static int getWeight(Coordinate pointA, Coordinate pointB, Map<Coordinate, Cell> grid) {

        if (pointA.equals(pointB)) {
            return 0;  // 点本身到本身的时间为 0
        }
        if (shadowPoints.contains(pointA) && shadowPoints.contains(pointB)) {//只有两端都处于阴影才算是ti的速度
            System.out.println("（"+ pointA.x + ", " + pointA.y + ")->"+ pointB.x + ", " + pointB.y + ")，ti：" + tiSpeed);
            return tiSpeed;
        }
        return defaultSpeed;
    }
}
