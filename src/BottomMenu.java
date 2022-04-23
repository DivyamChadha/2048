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
 * Panel that holds ArrowButtons.
 */
public class BottomMenu extends JPanel {
    /**
     * Constructor to initialise the bottom menu.
     * @param gameScreen The main game screen.
     */
    public BottomMenu(GameScreen gameScreen) {
        super();
        setLayout(new FlowLayout());
        this.add(new ArrowButton(ArrowButton.UP, gameScreen));  
        this.add(new ArrowButton(ArrowButton.DOWN, gameScreen)); 
        this.add(new ArrowButton(ArrowButton.LEFT, gameScreen)); 
        this.add(new ArrowButton(ArrowButton.RIGHT, gameScreen)); 
    }
}
