package com.lyb.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

/**
 * @author lyb
 * @version 1.0
 * @description: TODO
 * @date 2023/7/9 21:32
 */
public class MyButton extends JButton implements MouseListener {


    private Shape shape=null;
    private Color click=new Color(0,0,113);
    private Color quit=new Color(22, 237, 45);

    public MyButton(String text) {
        super(text);
        addMouseListener(this);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }
    public void setColor(Color c,Color q){
        click=c;
        quit=q;
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("exited");
    }

    @Override
    protected void paintComponent(Graphics g) {

        if (getModel().isArmed()){
            g.setColor(click);
        }else {
            g.setColor(quit);
        }

        g.fillRoundRect(0,0,getSize().width-1,getSize().height-1,20,20);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        g.setColor(quit);
        g.drawRoundRect(0,0,getSize().width-1,getSize().height-1,20,20);

    }

    @Override
    public boolean contains(int x, int y) {
        if (shape==null||!(shape.getBounds().equals(getBounds()))){
            shape=new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),20,20);
        }
        return shape.contains(x,y);
    }
}
