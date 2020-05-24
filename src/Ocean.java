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


    public void putShipsOnBoard(List<Ship> ships, List<List<Square>> squares) {
        for (int index = 0; index < ships.size(); index++){
            Ship localShip = ships.get(index);
            int localX = localShip.getCoordinateX();
            int localY = localShip.getCoordinateY();
            
            //TO DO check if no ship is there, if it wont go outside the board

            for (int i; i < localShip.size(); i++){
                List<Square> localRow = squares.get(localY);
                localRow.set(localX + i, localShip.get(0 + i)); 
            }
        }
    }


    @Override
    public String toString(){
        String StringBuilder = "";
        for (int y = 0; y < HEIGHT; y++){
            for (int x = 0; x < WIDTH; x++){
                StringBuilder += squares.get(y).get(x).toString();    
            }
            StringBuilder += "\n";
        }
        return StringBuilder;
    }

}