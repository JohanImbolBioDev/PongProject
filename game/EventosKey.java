package game;

import java.awt.event.*;

public class EventosKey extends KeyAdapter{
    static int idPress; 
    static int idReleased;
    @Override
    public void keyPressed(KeyEvent e) {
        idPress = e.getKeyCode();
    }
    @Override
    public void keyReleased(KeyEvent e) {
        idReleased = e.getKeyCode();
    }
}
