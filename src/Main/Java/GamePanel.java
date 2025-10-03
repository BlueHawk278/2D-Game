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

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); // improves game rendering performance
    }

    public void startGameThread(){
        gameThread = new Thread(this); // Passing this GamePanel class into Thread constructor
        gameThread.start(); // class run method
    }

    @Override // Inherited method from runnable interface that runs every frame
    public void run() {
        // Game Loop
        while(gameThread != null){
            update();
            repaint(); // calls paintComponent method
        }
    }

    // Updates positions
    public void update(){

    }

    // Updates positions to the screen
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; // convert graphics -> graphics 2D
        g2.setColor(Color.white);
        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose();
    }
}