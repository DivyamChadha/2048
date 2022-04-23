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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

/**
 * Button to start a game from a previosuly saved file on disk.
 */
public class OpenGameButton extends JButton implements ActionListener {
    JFileChooser jfChooser;
    GamePanel gamePanel;
    Game game;
    public OpenGameButton(JFileChooser jfChooser, GamePanel gamePanel) {
        super("Open Game");
        this.jfChooser = jfChooser;
        this.gamePanel = gamePanel;
        this.game = gamePanel.getGame();
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jfChooser.showOpenDialog(null);
        File file = jfChooser.getSelectedFile();

        try {
            if (file.canRead()) {
                Scanner Reader = new Scanner(file);
                if (Reader.hasNextLine()) {
                    String prefix = Reader.nextLine();
                    if (!prefix.equals("[Java2048Game]")) {
                        Reader.close();
                        return;
                    }
                    game.setScore(Reader.nextInt());
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            game.setValue(Reader.nextInt(), i, j);
                        }
                    }
                    gamePanel.update();
                }
                Reader.close();
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        
    }
}
