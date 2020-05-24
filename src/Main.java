import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        
        List<Ship> player1ships = new ArrayList<Ship>();

        Ship Carrier = new Ship(5, true, 3, 3);
        Carrier.getSqareByIndex(0).hit();
        player1ships.add(Carrier);


        Ocean player1Ocean = new Ocean(player1ships);
        System.out.print(player1Ocean.toString());
    }    
}