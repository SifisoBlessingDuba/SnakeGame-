package org.example;

import javax.swing.*;

public class GameFrame extends JFrame{
    GamePanel panel;

    GameFrame(){
        GamePanel panel = new GamePanel();
        this.setTitle("Snake Game");
        this.add(panel);
        this.pack();
        this.setVisible(true);
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        panel.requestFocusInWindow();
    }
}
