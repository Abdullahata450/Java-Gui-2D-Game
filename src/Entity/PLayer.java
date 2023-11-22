package Entity;
import  Main.Gamepanel;

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
        x=250;
        y=250;
        speed=3;
        direction ="down";

    }

    public void getPlayerImage(){
        try{
            up1= ImageIO.read(getClass().getResourceAsStream("/Players/moveup1.png"));
            up2= ImageIO.read(getClass().getResourceAsStream("/Players/moveup2.png"));
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

        spriteCounter++;
        if(spriteCounter>13){
            if (spriteNum==1){
                spriteNum=2;
            }
            else if (spriteNum==2) {
                spriteNum=1;
            }
            spriteCounter=0;
        }

    }

    public  void draw(Graphics g2){
        BufferedImage image=null;

        switch (direction){
            case "up":
                if(spriteNum==1){
                    image=up1;

                }
                if (spriteNum==2){
                    image=up2;
                }
                break;
            case "down":
                if(spriteNum==1){
                    image=down1;

                }
                if (spriteNum==2){
                    image=down2;
                }
                break;
            case "left":
                if (spriteNum==1){
                    image=left1;

                }
                if (spriteNum==2){
                    image=left2;
                }
                break;
            case "right":
                if (spriteNum==1)
                {
                    image=right1;

                }
                if (spriteNum==2){
                    image=right2;
                }
                break;

        }
        g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
    }



}
