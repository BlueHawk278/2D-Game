package Java.Entity;

import java.awt.image.BufferedImage;

// Stores variables that will be used in player and NPC classes
public class Entity {
    public int x, y;
    public int speed;

    // Buffered Image - Describes an image with an accessible buffer of image data - Used to store image files
    public BufferedImage up1, up2, left1, left2, right1, right2, down1, down2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;
}