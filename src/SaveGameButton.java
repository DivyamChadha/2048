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
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

/**
 * Button to save the current game state to a file on disk.
 */
public class SaveGameButton extends JButton implements ActionListener {
    JFileChooser jfChooser;
    GamePanel gamePanel;
    public SaveGameButton(JFileChooser jfChooser, GamePanel gamePanel) {
        super("Save Game");
        this.jfChooser = jfChooser;
        this.gamePanel = gamePanel;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jfChooser.showSaveDialog(null);
        File file = jfChooser.getSelectedFile();

        try {
            file.createNewFile();
            if (file.canWrite()) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("[Java2048Game]\n");
                fileWriter.write(Integer.toString(gamePanel.getGame().getScore()) + "\n");
                fileWriter.write(gamePanel.getGame().toString());
                fileWriter.close();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        

    }
}
