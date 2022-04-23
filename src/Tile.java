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
import javax.swing.border.LineBorder;

/**
 * The gui representation of the tile.
 */
public class Tile extends JLabel {
    public static final Color COLOR_2 = new Color(255, 255, 224); // light yellow
    public static final Color COLOR_4 = new Color(255, 228, 181); // moccasin
    public static final Color COLOR_8 = new Color(255, 222, 173); // navajowhite
    public static final Color COLOR_16 = new Color(255, 218, 185); // peachpuff
    public static final Color COLOR_32 = new Color(176, 226, 255); // light sky blue 1
    public static final Color COLOR_64 = new Color(164, 211, 238); // light sky blue 2
    public static final Color COLOR_128 = new Color(141, 182, 205); // light sky blue 3
    public static final Color COLOR_256 = new Color(255, 187, 255); // plum 1
    public static final Color COLOR_512 = new Color(171,	130,	255); // medium purple 1
    public static final Color COLOR_1024 = new Color(255,182,	193); // light pink
    public static final Color COLOR_2048 = new Color(255,130,	171); // pale violet red 1
    public static final Color COLOR_MAX = new Color(205,	104,	137); // pale violet red 3
    public static final Color COLOR_DEFAULT = Color.WHITE;

    /**
     * Constructor to initialise the tile.
     */
    public Tile() {
        super();
        setHorizontalAlignment(SwingConstants.CENTER);
        setMinimumSize(new Dimension(50, 50));
        setPreferredSize(new Dimension(50, 50));
        setMaximumSize(new Dimension(50, 50));
        setHorizontalAlignment(JLabel.CENTER);
        setBackground(COLOR_DEFAULT);
        setOpaque(true);
        setBorder(new LineBorder(Color.BLACK, 1, true));
    }

    /**
     * Update the tile color and text based provided value.
     * @param value New tile value
     */
    public void update(int value) {
        switch(value){
            case 2:
                setBackground(COLOR_2);
                break;
            case 4:
                setBackground(COLOR_4);
                break;
            case 8:
                setBackground(COLOR_8);
                break;
            case 16:
                setBackground(COLOR_16);
                break;
            case 32:
                setBackground(COLOR_32);
                break;
            case 64:
                setBackground(COLOR_64);
                break;
            case 128:
                setBackground(COLOR_128);
                break;
            case 256:
                setBackground(COLOR_256);
                break;
            case 512:
                setBackground(COLOR_512);
                break;
            case 1024:
                setBackground(COLOR_1024);
                break;
            case 2048:
                setBackground(COLOR_2048);
                break;
            default:
                setBackground(COLOR_DEFAULT);
                break;
        }
        if (value > 2048) setBackground(COLOR_MAX);
        setText(Integer.toString(value));
    }

    /**
     * Method to clear the value from tile.
     */
    public void clear() {
        setBackground(COLOR_DEFAULT);
        setText("");
    }
}
