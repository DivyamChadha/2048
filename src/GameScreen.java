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
 * The main and only frame for the 2048 application.
 */
public class GameScreen extends JFrame {
    Game game;
    GamePanel gamePanel;
    GameOver gameOver;
    JLabel scoreLabel;

    /**
     * Constructor to initialise the GameScreen.
     * @param game The core Game object
     */
    public GameScreen(Game game) {
        super();
        this.game = game;
        scoreLabel = new JLabel();
        gamePanel = new GamePanel(game, scoreLabel);
        gameOver = new GameOver(this);

        setTitle("2048");
        setSize(400,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;  

        gbc.gridx = 0;  
        gbc.gridy = 0;  
        this.add(new TopMenu(gamePanel), gbc);  

        gbc.gridx = 0;  
        gbc.gridy = 1;  
        this.add(new FeatureMenu(gamePanel), gbc);  

        gbc.gridx = 0;  
        gbc.gridy = 2;  
        JPanel scorePanel = new JPanel();
        scorePanel.add(scoreLabel);
        this.add(scorePanel, gbc);

        gbc.gridx = 0;  
        gbc.gridy = 3;  
        this.add(gamePanel, gbc);

        gbc.gridx = 0;  
        gbc.gridy = 4;  
        this.add(new BottomMenu(this), gbc);
        
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyKeyHandler(this));

        setVisible(true);
    }

    /**
     * Method to show/hide the game over dialog.
     */
    public void toggleGameOver() {
        gameOver.update();
        gameOver.setVisible(!gameOver.isVisible());
    }

    /**
     * Method to get the GamePanel
     * @return GamePanel
     */
    public GamePanel getGamePanel() {
        return this.gamePanel;
    }
}
