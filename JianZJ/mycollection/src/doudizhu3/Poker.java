package doudizhu3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Author JianZJ
 * @Date 2024/6/5 19:31
 */

public class Poker extends JLabel implements MouseListener {

    private String name;
    // 正反面
    private boolean up;
    // 是否能被点击
    private boolean canClick = false;
    //
    private boolean clicked = false;

    public Poker(String name, boolean up) {
        this.name = name;
        this.up = up;

        if (this.up) {
            turnFront();
        } else {
            turnRear();
        }

        this.setSize(71, 96);
        this.addMouseListener(this);
    }

    public Poker() {
    }

    public Poker(String name, boolean up, boolean canClick, boolean clicked) {
        this.name = name;
        this.up = up;
        this.canClick = canClick;
        this.clicked = clicked;
    }

    // 显示正面
    public void turnFront() {
        this.setIcon(new ImageIcon("mycollection\\src\\img\\poker\\" + name + ".png"));
        this.up = true;
    }

    // 显示反面
    public void turnRear() {
        this.setIcon(new ImageIcon("mycollection\\src\\img\\poker\\rear.png"));
        this.up = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (canClick) {
            int step = 0;
            if (clicked) {
                step += 20;
            } else {
                step -= 20;
            }
            clicked = !clicked;
            Point from = this.getLocation();
            Point to = new Point(from.x, from.y + step);
            this.setLocation(to);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * 设置
     * @param up
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * 获取
     * @return canClick
     */
    public boolean isCanClick() {
        return canClick;
    }

    /**
     * 设置
     * @param canClick
     */
    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    /**
     * 获取
     * @return clicked
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * 设置
     * @param clicked
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String toString() {
        return "Poker{name = " + name + ", up = " + up + ", canClick = " + canClick + ", clicked = " + clicked + "}";
    }
}
