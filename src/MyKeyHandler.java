/*
Author: Divyam Chadha
Enrollment No. A2305220299
Contact: divyamchdh@gmail.com
Program: ASET
Semester: 4
Section CSE5
Course: IT201 Java Programming
Submitted To: Amity University Noida
*/

import java.awt.*;
import java.awt.event.*;

/**
 * Class to handle key presses to move tiles in game.
 */
public class MyKeyHandler implements KeyEventDispatcher {
    Game game;
    GamePanel gamePanel;
    GameScreen gameScreen;

    private long lastKeyPressed = System.currentTimeMillis();
    private final long keyPressInterval = 250l;

    /**
     * Constructor to initialise MyKeyHandler.
     * @param gameScreen The main game screen
     */
    public MyKeyHandler(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.gamePanel = gameScreen.getGamePanel();
        this.game = gamePanel.getGame();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        long current = System.currentTimeMillis();
        if (current - lastKeyPressed > keyPressInterval)
            lastKeyPressed = current;
        else
            return false;

        int keyCode = e.getKeyCode();    
        switch (keyCode) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_KP_UP:
            case KeyEvent.VK_UP:
                game.mergeUp();
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_KP_DOWN:
            case KeyEvent.VK_DOWN:
                game.mergeDown();
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_KP_RIGHT:
            case KeyEvent.VK_RIGHT:
                game.mergeRight();
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_KP_LEFT:
            case KeyEvent.VK_LEFT:
                game.mergeLeft();
                break;

            default:
                break;
        }
        /**
         * We check if:
         *  Any space is left to generate a new tile
         *  If merging tiles in any direction would change the game state
         * If both of these conditions are false then the game is over.
         */
        if (!game.generateTile() && !game.movePossible()) {
            gameScreen.toggleGameOver();
        }
        gamePanel.update();
        return false;
    }
}
