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
 * Button to start a new game.
 * The new game can be of several types.
 * Default: New game with 2 random tiles.
 * End Game: Game with no more moves possible.
 * Square Colors: Game with different types of tiles to showcase tile colors.
 */
public class NewGameButton extends JButton implements ActionListener {
    public static final int DEFAULT         = 0b00;
    public static final int END_GAME        = 0b01;
    public static final int SQUARE_COLORS   = 0b10;

    Game game;
    GamePanel gamePanel;
    int type;

    /**
     * Constructor to initialise the NewGameButton.
     * @param newGameType The game type
     * @param gamePanel The panal containing the tiles
     */
    public NewGameButton(int newGameType, GamePanel gamePanel) {
        super();

        switch(newGameType) {
            case DEFAULT:
                setText("New Game");
                break;
            case END_GAME:
                setText("Game Over Demo");
                break;
            case SQUARE_COLORS:
                setText("All Colors Demo");
                break;
        }

        this.type = newGameType;
        this.game = gamePanel.getGame();
        this.gamePanel = gamePanel;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(type) {
            case DEFAULT:
                game.reset();
                break;
            case END_GAME:
                game.setAs(Game.gameOverDemo());
                break;
            case SQUARE_COLORS:
                game.setAs(Game.squareColorDemo());
                break;
        }
        gamePanel.update();
    }
}
