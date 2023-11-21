package Main;

import Entity.PLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Gamepanel extends JPanel implements Runnable {

  public   int tileSize = 18 * 3;
    int ScreenCol = 17;
    int ScreenRow = 14;
    int ScreenWidth = tileSize * ScreenCol;
    int ScreenHeight = tileSize * ScreenRow;
    Thread gameThread;
    Keyhandlers KEYH = new Keyhandlers();

    PLayer pLayer =new PLayer(this,KEYH);  // player class



    int playerX = 100; // Default positions
    int playerY = 100;
    int Playerspeed = 4;
    int FPS = 60;

    public Gamepanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.BLACK);
        this.addKeyListener(KEYH);
        this.setFocusable(true);
    }

    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {
        while (true) {
            update();
            repaint();

            try {
                Thread.sleep(18);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void update() {

        pLayer.update();   // update from player class
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        pLayer.draw(g2);   // draw from player class
        g2.dispose();
    }
}