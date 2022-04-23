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
 * Dialog which appears when no more move is possible.
 */
public class GameOver extends JDialog {
    GameScreen gameScreen;
    JLabel score;

    /**
     * Constructor to initialise the GameOver dialog.
     * @param gameScreen The main game screen.
     */
    public GameOver(GameScreen gameScreen) {
        this.gameScreen = gameScreen;

        setTitle("Game Over");
        setSize(400,200);
        setLocationRelativeTo(gameScreen);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;  

        gbc.gridx = 0;  
        gbc.gridy = 0;  
        this.add(new JLabel("Game Over"), gbc);  

        gbc.gridx = 0;  
        gbc.gridy = 1;  
        score = new JLabel("Score: " + gameScreen.getGamePanel().getGame().getScore());
        this.add(score, gbc);  
    }

    /**
     * Method to update the score on Label present on the dialog.
     */
    public void update() {
        score.setText("Score: " + gameScreen.getGamePanel().getGame().getScore());
    }
}
