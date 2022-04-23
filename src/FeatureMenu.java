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
 * Panel that holds NewGameButtons.
 * This panel is added so that user can see different functionality added to the app
 * which they might have otherwise might have taken a longer time to discover.
 */
public class FeatureMenu extends JPanel {
    JFileChooser jfChooser;
    /**
     * Constructor that initialise the feature menu.
     * @param gamePanel The main game screen.
     */
    public FeatureMenu(GamePanel gamePanel) {
        setLayout(new FlowLayout());
        this.add(new NewGameButton(NewGameButton.END_GAME, gamePanel));
        this.add(new NewGameButton(NewGameButton.SQUARE_COLORS, gamePanel)); 
    }
}
