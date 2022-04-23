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
import javax.swing.*;

/**
 * The panel which contains the gui representation of all tiles.
 */
public class GamePanel extends JPanel {
    Tile squares[] = new Tile[25];
    GridLayout layout;
    Game game;
    JLabel scoreLabel;

    /**
     * Constructor to initialise the GamePanel.
     * @param game The Game object
     */
    public GamePanel(Game game, JLabel scoreLabel) {
        super(new GridLayout(5, 5));
        this.game = game;
        this.scoreLabel = scoreLabel;

        layout = (GridLayout) this.getLayout();
        layout.setHgap(5);
        layout.setVgap(5);

        for (int i = 0; i < 25; i++) {
            squares[i] = new Tile();
            this.add(squares[i]);
        }

        this.setVisible(true);
        this.update();
    }

    /**
     * Method to update all Tiles in game.
     * This only uses the underlying Game object to update the gui to reflect the state.
     * It does not affect the game state itself.
     */
    public void update() {
        scoreLabel.setText("Score: " + Integer.toString(game.getScore()));
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!game.indexIsEmpty(i, j))
                    squares[(i*5)+j].update(game.getValue(i, j));
                else
                    squares[(i*5)+j].clear();   
            }
        }
    }

    /**
     * Method to get the Game object.
     * @return Game
     */
    public Game getGame() {
        return game;
    }
}
