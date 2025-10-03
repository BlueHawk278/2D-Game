package Java;

import javax.swing.*;

// In Java the upper left corner is X = 0, Y = 0
// X increases to the right
// Y increases as it goes down

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.startGameThread();
    }
}
