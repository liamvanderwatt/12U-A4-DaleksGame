
/**
 * This class models a Delek in the game. A Delek has a position and can advance
 * towards the Doctor.
 */
public class Dalek {

    private int row, col;
    private boolean hasCrashed;
    private boolean hasCaptured;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {
        int drow = doc.getRow();
        int dcol = doc.getCol();
        //advancing towards the doctor
        //checking if the row has changed
        if (drow > row) {
            this.row = row + 1;
        } else if (drow < row) {
            this.row = row - 1;
        }
        //checking if the colum has changed 
        if (dcol > col) {
            this.col = col + 1;
        } else if (dcol < col) {
            this.col = col - 1;
        }


    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
        //sets the crash to true
        
       hasCrashed =true;
    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
     
     
    public boolean hasCrashed(Dalek rob , Dalek d) {
      
        if (rob.getRow()== d.getRow()&& rob.getCol()== d.getCol()) {
            return true;
        } 

        return false;

    }
    //method for to test if the doctor is captured
    public boolean hasCaptured(Dalek rob , Doctor d){
       
        if (rob.getRow()== d.getRow()&& rob.getCol()== d.getCol()) {
            return true;
        } 

        return false;

    }
}
