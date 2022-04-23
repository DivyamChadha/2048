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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The core of the 2048 game project.
 * This class contains the entire logic of the game.
 */
public class Game {
    int[][] values = new int[5][5];
    int score;

    /**
     * Constructor to initialise the Game class.
     * This also generates 2 random tiles.
     */
    public Game() {
        generateTile();
        generateTile();
    }

    /**
     * Class method to return a game where no more moves are possible.
     * This is done to demonstarte the game over dialog.
     * @return Game
     */
    public static Game gameOverDemo() {
        Game g = new Game();
        g.clear();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                g.setValue( ((i*5)+j)%2==0 ? 2 : 4, i, j);
            }
        }
        return g;
    }
    
    /**
     * Class method to return tiles containing values upto 16384.
     * This is done to demonstarte all tile colors.
     * @return Game
     */
    public static Game squareColorDemo() {
        Game g = new Game();
        g.clear();
        g.setValue(2, 0, 0);
        g.setValue(4, 1, 0);
        g.setValue(8, 3, 0);
        g.setValue(16, 4, 0);
        g.setValue(32, 0, 1);
        g.setValue(64, 1, 1);
        g.setValue(128, 2, 1);
        g.setValue(256, 3, 1);
        g.setValue(512, 4, 1);
        g.setValue(1024, 0, 2);
        g.setValue(2048, 1, 2);
        g.setValue(2048<<1, 2, 2);
        g.setValue(2048<<3, 3, 2);
        
        return g;
    }

    /**
     * Method to create a copy of the game.
     * All values are copied.
     * @return Game
     */
    public Game copy() {
        Game g = new Game();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                g.setValue(getValue(i, j), i, j);
            }
        }
        return g;
    }

    /**
     * Private helper method to get a random int between 0(inclusive) and 5(exclusive).
     * @return
     */
    private int getRandom() {
        return ThreadLocalRandom.current().nextInt(0, 5);
    }

    /**
     * Method to check if each tile contains some value.
     * @return boolean
     */
    public boolean allTilesFull() {
        boolean flag = true;
        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (values[i][j] == 0) {
                    flag = false;
                    break outer;
                }
            }
        }
        return flag;
    }

    /**
     * Method to check if a move in any direction will result in a state change.
     * @return boolean
     */
    public boolean movePossible() {
        Game g = this.copy();
        g.mergeUp();
        if (!this.equals(g)) return true;

        g = this.copy();
        g.mergeDown();
        if (!this.equals(g)) return true;

        g = this.copy();
        g.mergeLeft();
        if (!this.equals(g)) return true;

        g = this.copy();
        g.mergeRight();
        if (!this.equals(g)) return true;

        return false;
    }

    /**
     * Method to generate a value (2 or 4) on a random tile.
     * If all tiles already contain some value, returns fale
     * @return boolean
     */
    public boolean generateTile() {
        if (allTilesFull()) return false;

        int i = ThreadLocalRandom.current().nextInt(1, 101);
        while(true) {
            int x = getRandom();
            int y = getRandom();
            if (indexIsEmpty(x, y)) {
                setValue(i<25 ? 4 : 2, x, y);
                break;
            }
        }
        return true;
    }

    /**
     * Check if a tile contains some value.
     * @param x Position at x axis (0-4)
     * @param y Position at y axis (0-4)
     * @return boolean
     */
    public boolean indexIsEmpty(int x, int y) {
        return values[x][y] == 0;
    }

    /**
     * Returns the value at given position.
     * @param x Position at x axis (0-4)
     * @param y Position at y axis (0-4)
     * @return int
     */
    public int getValue(int x, int y) {
        return values[x][y];
    }

    /**
     * Set the value at given index.
     * @param value Value to set
     * @param x Position at x axis (0-4)
     * @param y Position at y axis (0-4)
     */
    public void setValue(int value, int x, int y) {
        values[x][y] = value;
    }

    /**
     * Private helper method to merge values inside a list.
     * @param before The list containing the before state
     * @param after The list where the new state is added
     */
    private void merge(List<Integer> before, List<Integer> after) {
        for (Integer val : before) {
            if (after.size() == 0) after.add(val);
            else {
                int index = after.size() - 1;
                if (val.equals(after.get(index))) {
                    after.set(index, after.get(index)<<1);
                    score += val; 
                }
                else after.add(val);
            }
        }
    }

    /**
     * Merge all tiles in upward direction.
     */
    public void mergeUp() {
        List<Integer> before = new ArrayList<Integer>();
        List<Integer> after = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            before.clear();
            after.clear();

            for (int j = 0; j < 5; j++) {
                if (values[j][i] != 0)
                    before.add(values[j][i]);
                values[j][i] = 0;
            }

            merge(before, after);

            int count = 0;
            for (int j = 0; j < 5 && count < after.size(); j++) {
                values[j][i] = after.get(j);
                count++;
            }
        }
    }

    /**
     * Merge all tiles in downward direction.
     */
    public void mergeDown() {
        List<Integer> before = new ArrayList<Integer>();
        List<Integer> after = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            before.clear();
            after.clear();

            for (int j = 4; j >= 0; j--) {
                if (values[j][i] != 0)
                    before.add(values[j][i]);
                values[j][i] = 0;
            }

            merge(before, after);

            int count = 0;
            for (int j = 4; j >= 0 && count < after.size(); j--) {
                values[j][i] = after.get(4-j);
                count++;
            }
        }
    }

    /**
     * Merge all tiles in left direction.
     */
    public void mergeLeft() {
        List<Integer> before = new ArrayList<Integer>();
        List<Integer> after = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            before.clear();
            after.clear();

            for (int j = 0; j < 5; j++) {
                if (values[i][j] != 0)
                    before.add(values[i][j]);
                values[i][j] = 0;
            }

            merge(before, after);

            int count = 0;
            for (int j = 0; j < 5 && count < after.size(); j++) {
                values[i][j] = after.get(j);
                count++;
            }
        }
    }

    /**
     * Merge all tiles in right direction.
     */
    public void mergeRight() {
        List<Integer> before = new ArrayList<Integer>();
        List<Integer> after = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            before.clear();
            after.clear();

            for (int j = 4; j >= 0; j--) {
                if (values[i][j] != 0)
                    before.add(values[i][j]);
                values[i][j] = 0;
            }

            merge(before, after);

            int count = 0;
            for (int j = 4; j >= 0 && count < after.size(); j--) {
                values[i][j] = after.get(4-j);
                count++;
            }
        }
    }

    /**
     * Method to clear all tile values.
     */
    private void clear() {
        values = null;
        values = new int[5][5];
        score = 0;
    }

    /**
     * Method to reset the game to initial state.
     */
    public void reset() {
        clear();
        generateTile();
        generateTile();
    }

    /**
     * Method to copy tile values from a different game.
     * @param g Game to copy the values from
     */
    public void setAs(Game g) {
        clear();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                setValue(g.getValue(i, j), i, j);
            }
        }
    }

    @Override
    public String toString() {
        String s = new String();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                s = s.concat(Integer.toString(values[i][j]) + " ");
            }
            s = s.concat("\n");
            
        }
        return s;
    }

    /**
     * Method to check if the 2 games are equivalent.
     * i.e. every index has equal value.
     * The score is not taken into account.
     * @param g The Game to compare to
     * @return boolean
     */
    public boolean equals(Game g) {
        boolean flag = true;

        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (values[i][j] != g.getValue(i, j)) {
                    flag = false;
                    break outer;
                }
            }
        }

        return flag;
    }

    /**
     * Method to get the game score.
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * Method to set the game score.
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }
}
