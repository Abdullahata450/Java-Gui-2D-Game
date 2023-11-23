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
        tiles = new Tiles[6]; // Correcting array size to match the number of tiles
        mapTiles = new int[gp.WorldRow][gp.WorldCol]; // Swapping row and column for mapTiles

        getTileImage();
        loadMap();
    }

    public void loadMap() {
        try {
            InputStream is = getClass().getResourceAsStream("/Maps/world01.txt");
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));

            String line;
            int row = 0;

            while ((line = bf.readLine()) != null && row < gp.WorldRow) {
                String[] numbers = line.split(" "); // Split by any whitespace

                for (int col = 0; col < numbers.length && col < gp.WorldCol; col++) {
                    mapTiles[row][col] = Integer.parseInt(numbers[col]); // Store values properly in mapTiles
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
            tiles[0].imgage = ImageIO.read(getClass().getResourceAsStream("/TilesPhoto/newgrass.png"));

            tiles[1] = new Tiles();
            tiles[1].imgage = ImageIO.read(getClass().getResourceAsStream("/TilesPhoto/newWall.png"));

            tiles[2] = new Tiles();
            tiles[2].imgage = ImageIO.read(getClass().getResourceAsStream("/TilesPhoto/newWater.png"));

            tiles[3] = new Tiles();
            tiles[3].imgage = ImageIO.read(getClass().getResourceAsStream("/TilesPhoto/earth.png"));

            tiles[4] = new Tiles();
            tiles[4].imgage = ImageIO.read(getClass().getResourceAsStream("/TilesPhoto/tree.png"));

            tiles[5] = new Tiles();
            tiles[5].imgage = ImageIO.read(getClass().getResourceAsStream("/TilesPhoto/sand.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;

        while (row < gp.WorldRow) {
            while (col < gp.WorldCol) {
                int tileNum = mapTiles[row][col];

                int worldX = col * gp.tileSize;
                int worldY = row * gp.tileSize;

                int screenX = worldX - gp.pLayer.WorldX + gp.pLayer.ScreenX;
                int screenY = worldY - gp.pLayer.WorldY + gp.pLayer.ScreenY;

                g2.drawImage(tiles[tileNum].imgage, screenX, screenY, gp.tileSize, gp.tileSize, null);
                col++;
            }
            col = 0;
            row++;
        }
    }
}
