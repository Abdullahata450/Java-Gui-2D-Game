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
            up1= ImageIO.read(getClass().getResourceAsStream("/Players/back.png"));
//            up2= ImageIO.read(getClass().getResourceAsStream("/Players/boy_up_2.png"));
            down1= ImageIO.read(getClass().getResourceAsStream("/Players/default face.png"));
//            down2= ImageIO.read(getClass().getResourceAsStream("/Players/boy_down_1.png"));
            right1= ImageIO.read(getClass().getResourceAsStream("/Players/move right.png"));
//            right2= ImageIO.read(getClass().getResourceAsStream("/Players/boy_right_2.png"));
            left1= ImageIO.read(getClass().getResourceAsStream("/Players/move left.png"));
//            left2= ImageIO.read(getClass().getResourceAsStream("/Players/boy_left_1.png"));
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
