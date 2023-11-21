package Entity;
import  Main.Gamepanel;

import Main.Gamepanel;
import Main.Keyhandlers;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PLayer extends  Entity {
    Gamepanel gp;
    Keyhandlers KeyH;

    public  PLayer(Gamepanel gp,Keyhandlers KeyH){
       this.gp=gp;
       this.KeyH=KeyH;

        SetdefaultValues();
        getPlayerImage();
    }

    public void SetdefaultValues(){
        x=100;
        y=100;
        speed=4;
        direction ="down";

    }

    public void getPlayerImage(){
        try{
            up1= ImageIO.read(getClass().getResourceAsStream("/Players/moveup1"));
            up2= ImageIO.read(getClass().getResourceAsStream("/Players/moveup2"));
            down1= ImageIO.read(getClass().getResourceAsStream("/Players/moveDown1.png"));
            down2= ImageIO.read(getClass().getResourceAsStream("/Players/moveDonwn2.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/Players/moveRight1.png"));
            right2= ImageIO.read(getClass().getResourceAsStream("/Players/moveRight2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/Players/moveleft1.png"));
            left2= ImageIO.read(getClass().getResourceAsStream("/Players/moveleft2.png"));
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void update(){

        if (KeyH.upPressed) {
            direction="up";
            y -= speed;
        }
        else if (KeyH.downPressed) {
            direction="down";
            y += speed;
        }
        else if (KeyH.leftPressed) {
            direction="left";
            x -= speed;
        }
        else if (KeyH.rightPressed) {
            direction="right";
            x += speed;
        }
    }

    public  void draw(Graphics g2){
        BufferedImage image=null;

        switch (direction){
            case "up":
                image=up1;
                break;
            case "down":
                image=down1;
                break;
            case "left":
                image=left1;
                break;
            case "right":
                image=right1;
                break;

        }
        g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
    }



}
