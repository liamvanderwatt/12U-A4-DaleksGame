
import java.awt.Color;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    Board b;
    Doctor Who;
    Dalek dal;
    Dalek bob;
    Dalek jib;

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {
        //board variables
        b = new Board(12, 12);
        //doctors variables
        int r = (int) (Math.random() * 12);
        int c = (int) (Math.random() * 12);
        Who = new Doctor(r, c);
        b.putPeg(Color.GREEN, r, c);

        //dalek variables
        int rd = (int) (Math.random() * 12);
        int cd = (int) (Math.random() * 12);
        dal = new Dalek(rd, cd);
        b.putPeg(Color.black, rd, cd);
        int rd2 = (int) (Math.random() * 12);
        int cd2 = (int) (Math.random() * 12);
        bob = new Dalek(rd2, cd2);
        b.putPeg(Color.black, rd2, cd2);
        int rd3 = (int) (Math.random() * 12);
        int cd3 = (int) (Math.random() * 12);
        jib = new Dalek(rd3, cd3);
        b.putPeg(Color.black, rd3, cd3);
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        while (true) {
            //lets the doctor move
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            b.removePeg(Who.getRow(), Who.getCol());
            Who.move(clickRow, clickCol);
            b.putPeg(Color.GREEN, Who.getRow(), Who.getCol());

            b.removePeg(dal.getRow(), dal.getCol());

                
                if (dal.hasCrashed(dal, bob) ) {
                dal.crash();
                b.putPeg(Color.RED, dal.getRow(), dal.getCol());
            } else if (dal.hasCrashed(dal, jib)) {
                dal.crash();
                b.putPeg(Color.RED, dal.getRow(), dal.getCol());
            }else{
                //lets dalek move
                dal.advanceTowards(Who);
                b.putPeg(Color.BLACK, dal.getRow(), dal.getCol());
            }
            
            b.removePeg(bob.getRow(), bob.getCol());

           
            
                //checking if bob has crashed with other daleks 
            if (bob.hasCrashed(bob, dal) ) {
                bob.crash();
                b.putPeg(Color.RED, bob.getRow(), bob.getCol());
            } else if (bob.hasCrashed(bob, jib)) {
                bob.crash();
                b.putPeg(Color.RED, bob.getRow(), bob.getCol());
            } else{
                //lets dalek move
                bob.advanceTowards(Who);
                b.putPeg(Color.BLACK, bob.getRow(), bob.getCol());
            }
                
            b.removePeg(jib.getRow(), jib.getCol());
            
            
            //checking if jib has crashed with other daleks 
            if (jib.hasCrashed(jib, dal) ) {
                jib.crash();
                b.putPeg(Color.RED, jib.getRow(), jib.getCol());
                //checking if jib has crashed with other daleks 
            } else if (jib.hasCrashed(jib, bob)) {
                jib.crash();
                b.putPeg(Color.RED, jib.getRow(), jib.getCol());
            } else{
                 //lets dalek move
                jib.advanceTowards(Who);
                b.putPeg(Color.BLACK, jib.getRow(), jib.getCol());
            }
                
            //for when the doctor is captured
            if (dal.hasCaptured(dal, Who) || bob.hasCaptured(bob, Who) || jib.hasCaptured(jib, Who)) {
                b.displayMessage("zien doctor hus bien captured");
                b.putPeg(Color.yellow, Who.getRow(), Who.getCol());
                break;
            }
            //for when all the daleks have crashed
            if (dal.hasCrashed(dal, bob)&&bob.hasCrashed(bob, jib)&&jib.hasCrashed(jib, dal)){
                b.putPeg(Color.RED, bob.getRow(), bob.getCol());
                b.displayMessage("zien doctor hus von");
                break;
            }
        }
    }
}
