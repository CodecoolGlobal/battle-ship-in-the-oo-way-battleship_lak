import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Engine { 
    private static Scanner scanner = new Scanner(System.in);
    private static Sunk sunk = new Sunk();
    private static int turnCounter = 0;
    
    public void runGame() {
        int option = 1;
        boolean isRunning = true;

        while (option != 0 && isRunning == true) {

            try {
                printMenu();
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        fightPvC();
                        isRunning = false;
                        break;
                    case 2:
                        fightPvP();
                        isRunning = false;
                        break;
                    case 3:
                        fightCvC();
                        isRunning = false;
                        break;
                    case 0:
                        System.out.println("Bye bye");
                        break;
                    default:
                        ;
                }
                
            }
            catch (InputMismatchException e) {scanner.next();}
        }
    }

    
    private static void printMenu() {
        
        String options[] = {"Single player", "Multiplayer", "Simulation"};
        
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        
        System.out.println("WELCOME TO BATTLESHIP GAME\n");
        System.out.println("MENU:");

        for (int i = 1; i <= options.length; i++)
            System.out.println("  " + i + ". " + options[i - 1]);

        System.out.println("  0. Exit game.");
    }


    private static void fightPvC() {
        Ocean player1Ocean = getPlayerOcean();
        Ocean enemyOcean = getEnemyOcean();
        enemyOcean.hideBoard();
        
        GameBoard boardPVC = new GameBoard(enemyOcean, player1Ocean);
        DisplayBoard displayBoardPVC = new DisplayBoard(boardPVC.toString());
        
        clearScreen();
        displayBoardPVC.displayBoard();
        
        //Add fight

        int playerId = 1;
        int enemyId = 2;

        Player player1 = new Player(player1Ocean, playerId);
        Enemy enemy1 = new Enemy(enemyOcean, enemyId);

        gameLoopPvC(player1, enemy1, displayBoardPVC, boardPVC);

        if (player1.getIsDefeated() == true) {
            System.out.println("YOU LOST IN " + turnCounter + " TURNS");
        } else if (enemy1.getIsDefeated() == true) {
            System.out.println("YOU WON IN " + turnCounter + " TURNS");
        }

    }


    private static void gameLoopPvC(Player player1, Enemy enemy1, DisplayBoard displayBoardPVC, GameBoard boardPVC) {
        Ocean player1Ocean = player1.getPlayerOcean();
        Ocean enemyOcean = enemy1.getPlayerOcean();    

        while(player1.getIsDefeated() == false && enemy1.getIsDefeated() == false) {
            if(turnCounter % 2 == 0){
                player1.playerTurn(enemyOcean);
                sunk.checkIfSunk(enemyOcean);
                clearScreen();
                displayBoardPVC = new DisplayBoard(boardPVC.toString());
                displayBoardPVC.displayBoard();
                waitUntilEnter();
            } else {
                clearScreen();
                enemy1.enemyTurn(player1Ocean);
                sunk.checkIfSunk(player1Ocean);
                displayBoardPVC = new DisplayBoard(boardPVC.toString());
                displayBoardPVC.displayBoard();

            }

            player1.checkIfDefeated();
            enemy1.checkIfDefeated();

            turnCounter++;
        }
    }


    private static void gameLoopPvP(Player player1,Player player2, DisplayBoard displayBoard1PVP, GameBoard board1PVP,
                                    DisplayBoard displayBoard2PVP, GameBoard board2PVP) {

        Ocean player1Ocean = player1.getPlayerOcean();
        Ocean player2Ocean = player2.getPlayerOcean();

        while(player1.getIsDefeated() == false && player2.getIsDefeated() == false) {
            if(turnCounter % 2 == 0){
                player1.playerTurn(player2Ocean);
                sunk.checkIfSunk(player2Ocean);
                displayBoard1PVP = new DisplayBoard(board1PVP.toString());
                displayBoard1PVP.displayBoard();
                waitUntilEnter();

            } else {
                player2.playerTurn(player1Ocean);
                sunk.checkIfSunk(player1Ocean);
                displayBoard2PVP = new DisplayBoard(board2PVP.toString());
                displayBoard2PVP.displayBoard();
                waitUntilEnter();
            }

            player1.checkIfDefeated();
            player2.checkIfDefeated();

            turnCounter++;
        }
        
    }


    private static void fightPvP() {

        System.out.println("Player 1 set ship positions");
        waitUntilEnter();
        Ocean player1Ocean = getPlayerOcean();
        List<Ship> hiddenPlayer1Ships = crateShips();
        clearScreen();

        System.out.println(("Player 2 set ship positions"));
        waitUntilEnter();
        Ocean player2Ocean = getPlayerOcean();
        List<Ship> hiddenPlayer2Ships = crateShips();
        clearScreen();

        Ocean hiddenPlayer1Ocean = player1Ocean.deepCopyOcean(hiddenPlayer1Ships, player1Ocean.getShips());
        Ocean hiddenPlayer2Ocean = player2Ocean.deepCopyOcean(hiddenPlayer2Ships, player2Ocean.getShips());

        GameBoard board1PVP = new GameBoard(hiddenPlayer2Ocean, player1Ocean);
        GameBoard board2PVP = new GameBoard(hiddenPlayer1Ocean, player2Ocean);
        
        DisplayBoard displayBoard1PVP = new DisplayBoard(board1PVP.toString());
        DisplayBoard displayBoard2PVP = new DisplayBoard(board2PVP.toString());
        
        // dont display because you can see other player 
        // displayBoard1PVP.displayBoard();
        // displayBoard2PVP.displayBoard();

        //fight
        int playerId = 1;
        int player2Id = 2;

        Player player1 = new Player(player1Ocean, playerId);
        Player player2 = new Enemy(player2Ocean, player2Id);

        gameLoopPvP(player1, player2, displayBoard1PVP, board1PVP, displayBoard2PVP, board2PVP);

        if (player1.getIsDefeated() == true) {
            System.out.println("PLAYER 1 WON IN " + turnCounter + " TURNS");
        } else if (player2.getIsDefeated() == true) {
            System.out.println("PLAYER 2 WON IN " + turnCounter + " TURNS");
        }
    }


    private static void fightCvC() {
        Ocean enemy1Ocean = getEnemyOcean();
        Ocean enemy2Ocean = getEnemyOcean();
        
        GameBoard boardCVC = new GameBoard(enemy1Ocean, enemy2Ocean);
        
        DisplayBoard displayBoardCVC = new DisplayBoard(boardCVC.toString());
        displayBoardCVC.displayBoard();
    
        //Add fight
    }


    private static Ocean getPlayerOcean() {
        List<Ship> playerShips = crateShips();
        Ocean playerOcean = new Ocean(playerShips);

        playerOcean.putShipsOnBoard(playerShips, playerOcean);
        return playerOcean;
    }
    

    private static Ocean getEnemyOcean() {
        List<Ship> enemyShips = crateShips();
        Ocean enemyOcean = new Ocean(enemyShips);

        enemyOcean.generateEnemyOcean(enemyShips, enemyOcean);
        return enemyOcean;
    }


    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  


    private static void waitUntilEnter() {
        System.out.println("Press Enter to continue");
        try {
            System.in.read();
        } catch (Exception e) {};
    }


    private static List<Ship> crateShips() {
        Ship Carrier = new Ship("Carrier", 5, true, 0, 0);
        Ship Battleship = new Ship("Battleship", 4, true, 0, 0);
        Ship Cruiser = new Ship("Cruiser", 3, false, 0, 0);
        Ship Submarine = new Ship("Submarine", 3, true, 0, 0);
        Ship Destroyer = new Ship("Destroyer", 2, true, 0, 0);

        List<Ship> ships = Arrays.asList(Carrier, Battleship, Cruiser, Submarine, Destroyer);
        // List<Ship> ships = Arrays.asList(Destroyer);

        return ships;
    }
}   


