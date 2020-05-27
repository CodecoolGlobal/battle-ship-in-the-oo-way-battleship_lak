import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.lang.*;


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


    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }


    public void putShipsOnBoard(List<Ship> ships, Ocean ocean) {
        for (int i = 0; i < ships.size(); i ++) {
            getShipSettings(ocean, ships.get(i));
            putOneShipOnBoard(ocean, ships.get(i));
        }
    }


    private static void getShipSettings(Ocean ocean, Ship ship) {
        int coordinateX, coordinateY;
        boolean isCorrect = false;

        while (!isCorrect) {
            coordinateX = inputCoordinateX(ocean, ship, "letter");
            ship.setCoordinateX(coordinateX);
            coordinateY = inputCoordinateY(ocean, ship, "number");
            ship.setCoordinateY(coordinateY);
            isCorrect = checkIfInRadius(ocean, ship);
        }
    }


    private static void printShipSetup(boolean isVertical) {
        if (isVertical)
            System.out.println("Ship setup: Vertical");
        else
            System.out.println("Ship setup: Horizontal");
    }


    private static int inputCoordinateX(Ocean ocean, Ship ship, String numLetter) {
        List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        boolean isCorrect = false;
        String letter;
        int coordinate = 0;
        
        while (!isCorrect) {
            ocean.clearScreen();
            System.out.print(ocean.toString());
            System.out.println(ship.getNameOfShip() + " (" + ship.getShipLength() + ")");
            printShipSetup(ship.getIsVertical());
            System.out.print("Enter the coordinate by letter: ");
            letter = scanner.nextLine().toUpperCase();
            //letter = "A";
            coordinate = letters.indexOf(letter);
            isCorrect = checkCorrectCoordinate(ocean, ship, coordinate, numLetter);
        }
        return coordinate;
    } 


    private static int inputCoordinateY(Ocean ocean, Ship ship, String numLetter) {
        boolean isCorrect = false;
        int coordinate = 0;
        while (!isCorrect) {
            try {
                ocean.clearScreen();
                System.out.print(ocean.toString());
                System.out.println(ship.getNameOfShip() + " (" + ship.getShipLength() + ")");
                printShipSetup(ship.getIsVertical());
                System.out.print("Enter the coordinate by number: ");
                coordinate = scanner.nextInt() - 1;
                //coordinate = 7;
                isCorrect = checkCorrectCoordinate(ocean, ship, coordinate, numLetter);
            }
            catch (InputMismatchException e) {}
        }
        return coordinate; 
    }


    private static boolean checkCorrectCoordinate(Ocean ocean, Ship ship, int coordinate, String numLetter) {
        if (!checkIfInRange(ship, coordinate, numLetter)) 
            return false;
        else
            return true;
    }


    private static boolean checkIfInRange(Ship ship, int coordinate, String numLetter) {

        if (ship.getIsVertical() && numLetter.equals("number")) 
            return (0 <= coordinate && coordinate + ship.getShipLength() <= HEIGHT) ? true : false;
        else if (!ship.getIsVertical() && numLetter.equals("number")) 
            return (0 <= coordinate && coordinate < HEIGHT) ? true : false;
        else if (ship.getIsVertical() && numLetter.equals("letter")) 
            return (0 <= coordinate && coordinate < WIDTH) ? true : false;
        else
            return (0 <= coordinate && coordinate + ship.getShipLength() <= WIDTH) ? true : false;
    }


    private static boolean checkIfInRadius(Ocean ocean, Ship ship) {        
        if (ship.getIsVertical()) {
            return !ifInRadiusVertical(ocean, ship);
        }       
        return !ifInRadiusHorizontal(ocean, ship);
    }


    private static boolean ifInRadiusVertical(Ocean ocean, Ship ship) {
        int radius = 2;
        int cordinateX = ship.getCoordinateX();
        int cordinateY = ship.getCoordinateY();

        for (int i = 0; i < ship.getShipLength() ; i++) {
            for (int y = 0; y < HEIGHT; y++) {
                for (int x = 0; x < WIDTH; x++) {
                    if (Math.pow(radius, 2) > Math.pow((cordinateX - x), 2) + Math.pow((cordinateY + i - y), 2)) {
                        if (ocean.squares.get(y).get(x).getIsShip())
                            return true;
                    }
                }
            }
        }
        return false;
    }


    private static boolean ifInRadiusHorizontal(Ocean ocean, Ship ship) {
        int radius = 2;
        int cordinateX = ship.getCoordinateX();
        int cordinateY = ship.getCoordinateY();

        for (int i = 0; i < ship.getShipLength() ; i++) {
            for (int y = 0; y < HEIGHT; y++) {
                for (int x = 0; x < WIDTH; x++) {
                    if (Math.pow(radius, 2) > Math.pow((cordinateX + i - x), 2) + Math.pow((cordinateY - y), 2)) {
                        if (ocean.squares.get(y).get(x).getIsShip())
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private static void putOneShipOnBoard(Ocean ocean, Ship ship) {
         
        
        if (ship.getIsVertical()) {
            for (int index = 0; index < ship.getShipLength(); index++) {
                ocean.getSquares().get(ship.getCoordinateY() + index).set(ship.getCoordinateX(), ship.getSqareByIndex(index));
            }
        }
        else {
            for (int index = 0; index < ship.getShipLength(); index++) {
                ocean.getSquares().get(ship.getCoordinateY()).set(ship.getCoordinateX() + index, ship.getSqareByIndex(index));
            }            
        }
    }


    public List<List<Square>> getSquares() {
        return squares;
    }


    @Override
    public String toString(){
        String outputString = "   ";
        StringBuilder sB = new StringBuilder(outputString);
        sB.append("ABCDEFGHIJ\n");
        //sB.append("12345678910\n");

        sB.append("  ");
        for (int i = 0; i < WIDTH + 2; i++)
            sB.append("#");
        sB.append("\n");

        for (int y = 0; y < HEIGHT; y++){
            if (y + 1 <10)
                sB.append(" ");
            sB.append(y + 1 + "#");
            for (int x = 0; x < WIDTH; x++){
                sB.append(squares.get(y).get(x).toString());    
            }
            sB.append("#\n");
        }

        sB.append("  ");
        for (int i = 0; i < WIDTH + 2; i++)
            sB.append("#");
        sB.append("\n");

        outputString = sB.toString();
        return outputString;
    }

}