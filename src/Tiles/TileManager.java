package Tiles;

import Main.Gamepanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    Gamepanel gp;
    Tiles[] tiles;
    int[][] mapTiles;

    public TileManager(Gamepanel gp) {
        this.gp = gp;
        tiles = new Tiles[10];
        mapTiles = new int[gp.ScreenCol][gp.ScreenRow];

        getTileImage();
        LoadMap();
    }

    public void LoadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/Maps/TilesMap01.txt");
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            String Line;

            while (row < gp.ScreenRow && (Line = bf.readLine()) != null) {
                String[] numbers = Line.split(" ");

                for (int col = 0; col < gp.ScreenCol && col < numbers.length; col++) {
                    mapTiles[col][row] = Integer.parseInt(numbers[col]);
                }
                row++;
            }

            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tiles();
            tiles[0].imgage = ImageIO.read(getClass().getResourceAsStream("/TilesPhoto/grass.png"));

            tiles[1] = new Tiles();
            tiles[1].imgage = ImageIO.read(getClass().getResourceAsStream("/TilesPhoto/wall.png"));

            tiles[2] = new Tiles();
            tiles[2].imgage = ImageIO.read(getClass().getResourceAsStream("/TilesPhoto/water.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){

        int col=0;
        int row=0;
        int x=0;
        int y=0;

        while (col<gp.ScreenCol && row<gp.ScreenRow){
            int tilenum=mapTiles[col][row];
            g2.drawImage(tiles[tilenum].imgage,x,y,gp.tileSize,gp.tileSize,null);
            col++;
            x=x+gp.tileSize;

            if (col==gp.ScreenCol){
                col=0;
                x=0;
                row++;
                y=y+gp.tileSize;
            }
        }

    }
}
