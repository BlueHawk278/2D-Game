package Java.Entity;

import Java.GamePanel;
import Java.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel GamePanel;
    KeyHandler KeyHandler;

    public Player(GamePanel GamePanel, KeyHandler KeyHandler){
        this.GamePanel = GamePanel;
        this.KeyHandler = KeyHandler;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/boy_up_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/boy_right_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/assets/sprites/boy_down_2.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(){
        // Only checks for movement if a movement button is pressed
        if(KeyHandler.upPressed ||  KeyHandler.downPressed || KeyHandler.leftPressed || KeyHandler.rightPressed){
            // Checks if the key has been pressed and then changes position
            if(KeyHandler.upPressed){
                direction = "up";
                y -= speed;
            }
            else if(KeyHandler.downPressed){
                direction = "down";
                y += speed;
            }
            else if (KeyHandler.leftPressed){
                direction = "left";
                x -= speed;
            }
            else if(KeyHandler.rightPressed){
                direction = "right";
                x += speed;
            }

            // Changes sprite image 5 times per second
            spriteCounter++;
            if(spriteCounter > 12){ //60 / 12 = 5
                if(spriteNum == 1){ // checks if image is 1
                    spriteNum = 2; //  changes to 2
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage playerImage = null;
        switch (direction) {
            // Gets the direction of sprite and gives it the image associated with it
            case "up":
                if(spriteNum == 1){
                    playerImage = up1;
                }
                if(spriteNum == 2){
                    playerImage = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    playerImage = down1;
                }
                if(spriteNum == 2){
                    playerImage = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    playerImage = left1;
                }
                if(spriteNum == 2){
                    playerImage = left2;
                }
                break;
            case "right":
                playerImage = right1;
                if(spriteNum == 1){
                    playerImage = right2;
                }
                break;
        }

        g2.drawImage(playerImage, x, y, GamePanel.tileSize, GamePanel.tileSize,null); // observer -
    }
}