import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main { 
    public static void main(String[] args) {
        int option = 1;

        while (option != 0) {

            try {
                Scanner scanner = new Scanner(System.in);

                printMenu();
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        fightPvC();
                        break;
                    case 2:
                        fightPvP();
                        break;
                    case 3:
                        fightCvC();
                        break;
                    case 0:
                        System.out.println("Bye bye");
                        break;
                    default:
                        ;
                }
            }
            catch (InputMismatchException e) {}
        }
        
    }

    
    private static void printMenu() {
        
        String options[] = {"Single player", "Multiplayer", "Simulation"};
        
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        System.out.println("MENU:");

        for (int i = 1; i <= options.length; i++)
            System.out.println("  " + i + ". " + options[i - 1]);

        System.out.println("  0. Exit game.");
    }


    private static void fightPvC() {
        Ocean player1Ocean = getplayerOcean();
        //System.out.print(player1Ocean.toString());

        //Add random generetic enemyOcean
        //Add fight
    }


    private static void fightPvP() {
        Ocean player1Ocean = getplayerOcean(); 
        Ocean player2Ocean = getplayerOcean();
        
        //Add fight
    }


    private static void fightCvC() {
        // Add body of method
    }


    private static Ocean getplayerOcean() {
        List<Ship> playerships = crateShips();
        Ocean playerOcean = new Ocean(playerships);

        playerOcean.putShipsOnBoard(playerships, playerOcean);
        return playerOcean;
    }
    

    private static List<Ship> crateShips() {
        Ship Carrier = new Ship("Carrier", 5, true, 0, 0);
        Ship Battleship = new Ship("Battleship", 4, true, 0, 0);
        Ship Cruiser = new Ship("Cruiser", 3, false, 0, 0);
        Ship Submarine = new Ship("Submarine", 3, true, 0, 0);
        Ship Destroyer = new Ship("Destroyer", 2, true, 0, 0);

        List<Ship> ships = Arrays.asList(Carrier, Battleship, Cruiser, Submarine, Destroyer);
        return ships;
    }   
}   


