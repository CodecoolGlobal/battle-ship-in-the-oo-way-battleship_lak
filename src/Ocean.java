import java.util.List;
import java.util.ArrayList;

public class Ocean {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private List<List<Square>> squares;
    private List<Ship> ships;


    public Ocean(List<Ship> ships) {
        
        for (int i = 0; i < HEIGHT; i++) {
            List<Square> localSquares = new ArrayList<Square>();

            for (int j = 0; j < WIDTH; i++) {
                Square localSquare = new Square();
                localSquares.add(localSquare);    
            }
            this.squares.add(localSquares);
        }
        
        //this.squares = squares;
        this.ships = ships;
    }



    
}