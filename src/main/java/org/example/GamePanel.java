package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int screenWidth = 600;
    static final int screenHeight = 600;
    static final int unitSize = 15;
    static final int gameUnit = (screenWidth * screenHeight) / unitSize;
    static final int delay = 100;
    final int x[] = new int[gameUnit];
    final int y[] = new int[gameUnit];
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'D';
    boolean running = false;
    Timer timer;
    Random random;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color (141, 169, 196));
        this.setFocusable(true);
        this.addKeyListener(new myKeyAdapter());
        this.requestFocusInWindow();
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
           /*for (int i = 0; i < screenHeight / unitSize; i++) {
                g.drawLine(i * unitSize, 0, i * unitSize, screenHeight);
                g.drawLine(0, i * unitSize, screenWidth, i * unitSize);
            }*/
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, unitSize, unitSize);
            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                } else {
                    g.setColor(new Color(30, 215, 96));
                    g.fillRect(x[i], y[i], unitSize, unitSize);
                }
            }
        }else{
            gameOver(g);
        }
        g.setColor(new Color(20, 30, 60));
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (screenWidth - metrics.stringWidth("Score: " + applesEaten)) / 2 , g.getFont().getSize());
    }

    public void newApple() {
        appleX = random.nextInt((int) screenWidth / unitSize) * unitSize;
        appleY = random.nextInt((int) screenHeight / unitSize) * unitSize;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        switch (direction) {
            case 'A':
                x[0] = x[0] - unitSize;
                break;
            case 'S':
                y[0] = y[0] + unitSize;
                break;
            case 'W':
                y[0] = y[0] - unitSize;
                break;
            case 'D':
                x[0] = x[0] + unitSize;
                break;
        }
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        if (x[0] < 0 || x[0] >= screenWidth || y[0] < 0 || y[0] >= screenHeight) {
            running = false;
        }

        if (!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        g.setColor(new Color(20, 30, 60));
        g.setFont(new Font("Arial", Font.BOLD, 100));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (screenWidth - metrics.stringWidth("Game Over")) / 2 , screenHeight / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class myKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (direction != 'S') {
                        direction = 'W';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'W') {
                        direction = 'S';
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (direction != 'D') {
                        direction = 'A';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'A') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
