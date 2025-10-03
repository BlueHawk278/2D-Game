package Java;

import javax.swing.*;
import java.awt.*;
                                      // Allows us to use threading
public class GamePanel extends JPanel implements Runnable{

    // Screen Settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48x48 - Actual tile size displayed on screen
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenColumn; // 768 pixels - 16 * 48
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels - 16 * 12

    int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 10;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // improves game rendering performance
        this.addKeyListener(keyHandler); // adds keyListener to get key actions
        this.setFocusable(true); // GamePanel can be focused to receive key input
    }

    public void startGameThread(){
        gameThread = new Thread(this); // Passing this GamePanel class into Thread constructor
        gameThread.start(); // class run method
    }

    @Override // Inherited method from runnable interface that runs every frame
    public void run() {
        double drawInterval = (double) 1_000_000_000 / FPS; // 0.016 sec = 16,666,666.66 nano
        double nextDrawTime = System.nanoTime() + drawInterval; // the time when the next frame is printed

        // Game Loop
        while(gameThread != null){
            long currentTime = System.nanoTime(); // 1 sec = 1,000,000,000 nano
            update();
            repaint(); // calls paintComponent method

            try{
                double remainingTime = nextDrawTime - currentTime; // checks how long until next frame
                remainingTime /= 1_000_000; // convert nanoseconds to milliseconds

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime); // sleeps until the next frame

                nextDrawTime += drawInterval;
            }
            catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // Updates positions
    public void update(){
        // Checks if the key has been pressed and then changes position
        if(keyHandler.upPressed){
            playerY -= playerSpeed;
        }
        else if(keyHandler.downPressed){
            playerY += playerSpeed;
        }
        else if (keyHandler.leftPressed){
            playerX -= playerSpeed;
        }
        else if(keyHandler.rightPressed){
            playerX += playerSpeed;
        }
    }

    // Updates positions to the screen
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // convert graphics -> graphics 2D
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();
    }
}