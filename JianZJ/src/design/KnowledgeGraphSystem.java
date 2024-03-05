package design;

/**
 * @Author JianZJ
 * @Date 2024/3/5 18:11
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KnowledgeGraphSystem extends JFrame implements ActionListener {
    private JPanel graphPanel;
    private JButton addNodeButton, addEdgeButton;
    private ArrayList<KnowledgeNode> nodes;
    private ArrayList<KnowledgeEdge> edges;
    private Map<KnowledgeNode, Point> nodePositions;

    public KnowledgeGraphSystem() {
        setTitle("Knowledge Graph System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGraph(g);
            }
        };
        graphPanel.addMouseListener(new MouseClickListener());
        add(graphPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addNodeButton = new JButton("Add Node");
        addEdgeButton = new JButton("Add Edge");
        addNodeButton.addActionListener(this);
        addEdgeButton.addActionListener(this);
        buttonPanel.add(addNodeButton);
        buttonPanel.add(addEdgeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        nodePositions = new HashMap<>();
    }

    private void drawGraph(Graphics g) {
        // Draw edges
        g.setColor(Color.BLACK);
        for (KnowledgeEdge edge : edges) {
            Point start = nodePositions.get(edge.getStartNode());
            Point end = nodePositions.get(edge.getEndNode());
            g.drawLine(start.x, start.y, end.x, end.y);
            g.drawString(edge.getType(), (start.x + end.x) / 2, (start.y + end.y) / 2);
        }

        // Draw nodes
        for (KnowledgeNode node : nodes) {
            Point position = nodePositions.get(node);
            g.setColor(Color.BLUE);
            g.fillOval(position.x - 20, position.y - 20, 40, 40);
            g.setColor(Color.BLACK);
            g.drawString(node.getType(), position.x - 10, position.y + 5);
        }
    }

    private void addNode() {
        String name = JOptionPane.showInputDialog(this, "Enter the name of the node:");
        if (name != null && !name.isEmpty()) {
            String age = JOptionPane.showInputDialog(this, "Enter the age of the node:");
            String gender = JOptionPane.showInputDialog(this, "Enter the gender of the node:");
            String hobby = JOptionPane.showInputDialog(this, "Enter the hobby of the node:");
            KnowledgeNode newNode = new KnowledgeNode(name);
            newNode.getProperties().put("Age", age);
            newNode.getProperties().put("Gender", gender);
            newNode.getProperties().put("Hobby", hobby);
            nodes.add(newNode);
            Point position = generateRandomPosition();
            nodePositions.put(newNode, position);
            repaint();
        }
    }

    private void addEdge() {
        if (nodes.size() < 2) {
            JOptionPane.showMessageDialog(this, "Please create at least two nodes first.");
            return;
        }
        String startNodeName = JOptionPane.showInputDialog(this, "Enter the name of the start node:");
        String endNodeName = JOptionPane.showInputDialog(this, "Enter the name of the end node:");
        String edgeType = JOptionPane.showInputDialog(this, "Enter the type of the edge:");
        KnowledgeNode startNode = findNodeByName(startNodeName);
        KnowledgeNode endNode = findNodeByName(endNodeName);
        if (startNode != null && endNode != null) {
            edges.add(new KnowledgeEdge(startNode, endNode, edgeType));
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Node not found.");
        }
    }

    private KnowledgeNode findNodeByName(String name) {
        for (KnowledgeNode node : nodes) {
            if (node.getType().equals(name)) {
                return node;
            }
        }
        return null;
    }

    private Point generateRandomPosition() {
        int x = (int) (Math.random() * (graphPanel.getWidth() - 40)) + 20;
        int y = (int) (Math.random() * (graphPanel.getHeight() - 40)) + 20;
        return new Point(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addNodeButton) {
            addNode();
        } else if (e.getSource() == addEdgeButton) {
            addEdge();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KnowledgeGraphSystem system = new KnowledgeGraphSystem();
            system.setVisible(true);
        });
    }

    class MouseClickListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            for (KnowledgeNode node : nodes) {
                Point position = nodePositions.get(node);
                if (position != null && Math.pow(e.getX() - position.x, 2) + Math.pow(e.getY() - position.y, 2) <= 400) {
                    StringBuilder info = new StringBuilder();
                    info.append("Name: ").append(node.getType()).append("\n");
                    for (Map.Entry<String, String> property : node.getProperties().entrySet()) {
                        info.append(property.getKey()).append(": ").append(property.getValue()).append("\n");
                    }
                    JOptionPane.showMessageDialog(KnowledgeGraphSystem.this, info.toString(), "Node Information", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        }
    }
}

class KnowledgeNode {
    private String type;
    private Map<String, String> properties;

    public KnowledgeNode(String type) {
        this.type = type;
        this.properties = new HashMap<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}

class KnowledgeEdge {
    private KnowledgeNode startNode;
    private KnowledgeNode endNode;
    private String type;

    public KnowledgeEdge(KnowledgeNode startNode, KnowledgeNode endNode, String type) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.type = type;
    }

    public KnowledgeNode getStartNode() {
        return startNode;
    }

    public void setStartNode(KnowledgeNode startNode) {
        this.startNode = startNode;
    }

    public KnowledgeNode getEndNode() {
        return endNode;
    }

    public void setEndNode(KnowledgeNode endNode) {
        this.endNode = endNode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
