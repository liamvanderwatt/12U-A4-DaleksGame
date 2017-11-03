
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vandl4973
 */
public class Boards {

   
  

    public static void mains(String[] args) {
        // TODO code application logic here
        Board b = new Board(12, 12);
        b.putPeg(Color.GREEN, 3, 5);
        b.putPeg(Color.BLUE, 11, 11);
        //removes the peg
        b.removePeg(3, 5);
        //message
        b.displayMessage("helloeveryone");

        while (true) {
            //recive click from user
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            //put peg down
            b.putPeg(Color.BLACK, clickRow, clickCol);
        }
    }
}
