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
 * Panel that holds buttons with different functionalities.
 */
public class TopMenu extends JPanel {
    JFileChooser jfChooser;

    /**
     * Constructor to initialise the top menu.
     * @param gamePanel The panal containing the tiles
     */
    public TopMenu(GamePanel gamePanel) {
        setLayout(new FlowLayout());
        this.add(new NewGameButton(NewGameButton.DEFAULT, gamePanel));
        
        jfChooser = new JFileChooser();
        this.add(new SaveGameButton(jfChooser, gamePanel)); 
        this.add(new OpenGameButton(jfChooser, gamePanel)); 
    }
}
