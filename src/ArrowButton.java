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

import java.awt.event.*;
import javax.swing.JButton;

/**
 * Button that provides gui functionality to merge the game tiles. 
 */
public class ArrowButton extends JButton implements ActionListener {
    public static final int UP      = 0b00;
    public static final int DOWN    = 0b01;
    public static final int LEFT    = 0b10;
    public static final int RIGHT   = 0b11;

    int direction;
    Game game;
    GameScreen gameScreen;
    GamePanel gamePanel;

    /**
     * Constructor to initialise an ArrowButton.
     * @param direction The direction this ArrowButton should merge the tiles.
     * @param gameScreen The main application frame.
     */
    public ArrowButton(int direction, GameScreen gameScreen) {
        super();
        this.direction = direction;
        this.gameScreen = gameScreen;
        this.gamePanel = gameScreen.getGamePanel();
        this.game = gamePanel.getGame();

        switch (direction) {
            case ArrowButton.UP:
                setText("↑");
                break;
            case ArrowButton.DOWN:
                setText("↓");
                break;
            case ArrowButton.LEFT:
                setText("←");
                break;
            case ArrowButton.RIGHT:
                setText("→");
                break;
            default:
                setText("?");
                break;
        }
        
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (direction) {
            case ArrowButton.UP:
                game.mergeUp();
                break;
            case ArrowButton.DOWN:
                game.mergeDown();
                break;
            case ArrowButton.LEFT:
                game.mergeLeft();
                break;
            case ArrowButton.RIGHT:
                game.mergeRight();
                break;
            default:
                System.out.println("Invalid Direction\n");
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
    }
}
