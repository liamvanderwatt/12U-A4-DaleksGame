
import java.awt.Color;

/**
 * This class models the Doctor in the game. A Doctor has a position and can
 * move to a new position.
 */
public class Doctor {

    private int row, col;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        this.col = theCol;
        this.row = theRow;

    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        //if the doctor wants to move
        if (newRow == row + 1) {
            this.row = row + 1;
        }
        if (newRow == row - 1) {
            this.row = row - 1;
        }
        if (newCol == col + 1) {
            this.col = col + 1;
        }
        if (newCol == col - 1) {
            this.col = col - 1;
        }
        //for diagonals 
        if (newRow == row - 1 && newCol == col + 1) {
            this.row = row - 1;
            this.col = col + 1;
        }
        if (newRow == row + 1 && newCol == col + 1) {
            this.row = row + 1;
            this.col = col + 1;
        }
        if (newRow == row + 1 && newCol == col - 1) {
            this.row = row + 1;
            this.col = col - 1;
        }
        if (newRow == row - 1 && newCol == col - 1) {
            this.row = row - 1;
            this.col = col - 1;
        }
        //creating the teleport function
        if (newRow > row + 1) {
            this.row = (int) (Math.random() * 12);
            this.col = (int) (Math.random() * 12);
        }
        if (newCol > col + 1) {
            this.row = (int) (Math.random() * 12);
            this.col = (int) (Math.random() * 12);
        }
        if (newRow < row - 1) {
            this.row = (int) (Math.random() * 12);
            this.col = (int) (Math.random() * 12);
        }
        if (newCol < col - 1) {
            this.row = (int) (Math.random() * 12);
            this.col = (int) (Math.random() * 12);
        }
        //if the user decides to wait a turn
        if (newRow == row && newCol == col) {
            this.row = newRow;
            this.col = newCol;
        }

    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        return this.col;
    }
}
