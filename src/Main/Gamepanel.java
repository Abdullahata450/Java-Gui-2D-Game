package Main;

import Entity.PLayer;       // import form packesges Entity
import Tiles.TileManager; // import form packeges Tils

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.security.PublicKey;
import javax.swing.JPanel;

public class Gamepanel extends JPanel implements Runnable {

  public   int tileSize = 16 * 3;
   public int ScreenCol = 16;
    public int ScreenRow = 12;
    public int ScreenWidth = tileSize * ScreenCol;
    public int ScreenHeight = tileSize * ScreenRow;


    // World map setting 50 by 50 world01 MAP
    public int WorldCol=50;
    public int WorldRow=50;
    public int WorldHeight=tileSize * WorldCol;
    public int WorldWidth=tileSize * WorldRow;



    Thread gameThread;
   public Keyhandlers KEYH = new Keyhandlers();

   public PLayer pLayer =new PLayer(this,KEYH);  // player class

   public TileManager tileM=new TileManager(this); // tile Manager class;









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
                Thread.sleep(19);
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

        tileM.draw(g2); // draw form Tilemanager class
        pLayer.draw(g2);   // draw from player class


        g2.dispose();
    }
}