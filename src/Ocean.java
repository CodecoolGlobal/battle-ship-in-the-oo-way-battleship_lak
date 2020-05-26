import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class Ocean {

    private static Scanner scanner = new Scanner(System.in);

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private List<List<Square>> squares;
    private List<Ship> ships;


    public Ocean(List<Ship> ships) {    
        List<List<Square>> squares = new ArrayList<List<Square>>();
        for (int i = 0; i < HEIGHT; i++) {
            List<Square> localSquares = new ArrayList<Square>();

            for (int j = 0; j < WIDTH; j++) {
                Square localSquare = new Square();
                localSquares.add(localSquare);    
            }
            squares.add(localSquares);
        }
        
        this.squares = squares;
        this.ships = ships;
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }


    public void putShipsOnBoard(List<Ship> ships, Ocean ocean) {
        for (int i = 0; i < ships.size(); i ++) {
            getCoordinates(ocean, ships.get(i));
            putOneShipOnBoard(ocean, ships.get(i));
        }

        /*for (int index = 0; index < ships.size(); index++){
            Ship localShip = ships.get(index);
            int localX = localShip.getCoordinateX();
            int localY = localShip.getCoordinateY();
            
            //TO DO check if no ship is there, if it wont go outside the board

            for (int i = 0; i < localShip.getShipLength(); i++){
                List<Square> localRow = squares.get(localY);
                localRow.set(localX + i, localShip.getSqareByIndex(0 + i)); 
            }
        }*/
    }

    private static void getCoordinates(Ocean ocean, Ship ship) {
        boolean isCorrect = false;

        while (!isCorrect) {
            try {
                clearScreen();
                System.out.println(ship.getNameOfShip());
                System.out.print("Enter the coordinate X: ");
                ship.setCoordinateX(scanner.nextInt());
                System.out.print("Enter the coordinate Y: ");
                ship.setCoordinateY(scanner.nextInt());
                isCorrect = true;
            }
            catch (InputMismatchException e) {
                isCorrect = false;
            }
        }
    }

    private static void putOneShipOnBoard(Ocean ocean, Ship ship) {
         
        
        if (ship.getIsVertical()) {
            for (int index = 0; index < ship.getShipLength(); index++) {
                ocean.getSquares().get(ship.getCoordinateY() + index).set(ship.getCoordinateX(), ship.getSqareByIndex(index));
            }
        }
        else {
            
        }
    }


    public List<List<Square>> getSquares() {
        return squares;
    }


    @Override
    public String toString(){
        String outputString = "";
        for (int y = 0; y < HEIGHT; y++){
            for (int x = 0; x < WIDTH; x++){
                outputString += squares.get(y).get(x).toString();    
            }
            outputString += "\n";
        }
        return outputString;
    }

}