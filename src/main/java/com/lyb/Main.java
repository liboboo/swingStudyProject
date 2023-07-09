package com.lyb;

import javax.swing.*;
import java.awt.*;

/**
 * @author lyb
 * @version 1.0
 * @description: TODO
 * @date 2023/7/9 21:32
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new CustomFrame("Test");

            frame.setVisible(true);
        });
    }
}
