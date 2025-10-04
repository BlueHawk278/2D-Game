package Java;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Listener interface for receiving keyboard events
public class KeyHandler implements KeyListener {
    @Override // Don't use
    public void keyTyped(KeyEvent e) {

    }

    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override // Checks for keys pressed
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // returns integer keycode associated with the key pressed

        // Checks if a key is pressed setting keyPressed to true
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        else if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        else if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        else if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
    }

    @Override // Checks for keys released
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        // Checks if a key has been released setting keyPressed to false
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        else if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        else if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        else if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
    }
}
