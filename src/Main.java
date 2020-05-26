import java.util.List;
import java.util.Arrays;


public class Main { 
    public static void main(String[] args) {
        
        List<Ship> player1ships = crateShips();

        // Carrier.getSqareByIndex(0).hit();


        Ocean player1Ocean = new Ocean(player1ships);
        player1Ocean.putShipsOnBoard(player1ships, player1Ocean);
        System.out.print(player1Ocean.toString());
    }
    
    
    private static List<Ship> crateShips() {
        Ship Carrier = new Ship("Carrier", 5, true, 0, 0);
        Ship Battleship = new Ship("Battleship", 4, true, 0, 0);
        Ship Cruiser = new Ship("Cruiser", 3, true, 0, 0);
        Ship Submarine = new Ship("Submarine", 3, true, 0, 0);
        Ship Destroyer = new Ship("Destroyer", 2, true, 0, 0);

        List<Ship> ships = Arrays.asList(Carrier, Battleship, Cruiser, Submarine, Destroyer);
        return ships;
    }   
}


