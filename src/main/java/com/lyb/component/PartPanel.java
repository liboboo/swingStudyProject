package com.lyb.component;

import javax.swing.*;
import java.awt.*;

/**
 * @author lyb
 * @version 1.0
 * @description: TODO
 * @date 2023/7/9 21:34
 */
public class PartPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public PartPanel() {
        super();
        setSize(200,200);
        setOpaque(false);
        int w=getSize().width;
        int h=getSize().height;
        setSize(w+5,h+5);
        setBackground(Color.GREEN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int fieldX = 0;
        int fieldY = 0;
        int fieldWeight = getSize().width;
        int fieldHeight = getSize().height;
        Graphics2D g2d=(Graphics2D)g;
        Color bg = new Color(128, 128, 128, 50);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(bg);
        g.fillRoundRect(fieldX, fieldY, fieldWeight, fieldHeight, 20, 20);

        super.paintChildren(g);//可以正常显示该组件中添加的组件
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("圆角面板");
        frame.setLayout(null);
        frame.setBounds(500, 300, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel root = new JPanel();
        PartPanel panel = new PartPanel();
        panel.setPreferredSize(new Dimension(100,100));
        panel.setLocation(100, 100);
        JButton test = new MyButton("test");
        panel.add(test);
        root.add(panel);
        frame.setContentPane(root);
        frame.setBackground(Color.RED);
        frame.setVisible(true);
    }
}
