import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {  
    private static Scanner scanner = new Scanner(System.in);
    private Ocean playerOcean;
    private int playerId;
    private boolean isDefeated = false;


    public Player(Ocean playerOcean, int playerId) {
        this.playerOcean = playerOcean;
        this.playerId = playerId;
    }


    public Ocean getPlayerOcean() {
        return playerOcean;
    }


    public int getPlayerId() {
        return playerId;
    }


    public boolean getIsDefeated() {
        return isDefeated;
    }


    public void setIsDefeatedTrue() {
        isDefeated = true;
    }


    public void playerTurn(Ocean enemyOcean) {
        printMessage();
        Coordinates chosenSqureCoordinates = getChoice();
        markChosenSquare(chosenSqureCoordinates, enemyOcean);
    }


    public void printMessage () {
        System.out.println("It is now Player " + playerId + " turn");
    }


    // REFACTOR HERE, Create field in ocean object in which stores array of coordinates,
    // import it here
    public Coordinates getChoice () {
        List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        List<String> strNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
 
        System.out.println("Choose letter of field, which you would like to strike.");
        int xCoordinate = getCoordinateFromPlayer(letters);

        System.out.println("Choose letter of field, which you would like to strike.");
        int yCoordinate = getCoordinateFromPlayer(strNumbers);

        Coordinates coordinates = new Coordinates(xCoordinate, yCoordinate);
        return coordinates;
    }


    public int getCoordinateFromPlayer (List<String> valuesList) {
        boolean isRunning = true;
        // Scanner scanner = new Scanner(System.in);
        int coordinate = 0;

        while (isRunning == true) {
            String playerInput = scanner.nextLine().toUpperCase();
            if (valuesList.contains(playerInput)) {
                coordinate = valuesList.indexOf(playerInput);
                isRunning = false;
            }

        }

        // scanner.close();
        return coordinate;
    }

    public void markChosenSquare (Coordinates chosenSqureCoordinates, Ocean targetOcean) {
        Square chosenSquare = targetOcean.getSqare(chosenSqureCoordinates);
        chosenSquare.hit();
    }


    public void checkIfDefeated () {
        List<Ship> playerShips = playerOcean.getShips();
        // first all ShipsSunk is set to true, then if exits ship which is not sunk, set it to false
        boolean allShipsSunk = true;

        for (int index = 0; index < playerShips.size(); index++) {
            Ship nextShip = playerShips.get(index);
            nextShip.updateIsSunk();

            if (nextShip.getIsSunk() == false) {
                allShipsSunk = false;
            }
        }

        if (allShipsSunk == true) { 
            setIsDefeatedTrue();
        }
    }

}
