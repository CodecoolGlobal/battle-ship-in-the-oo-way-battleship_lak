import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {  
    //close it
    private Scanner scanner = new Scanner(System.in);
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


    public Coordinates getChoice () {
        List<String> letters = playerOcean.getLetters();
        List<String> strNumbers = playerOcean.getStrNumbers();
 
        System.out.println("Choose coordinates, which you would like to strike");

        Coordinates coordinates = getCoordinatesFromPlayer(letters, strNumbers);
        return coordinates;
    }


    public Coordinates getCoordinatesFromPlayer (List<String> valuesListLetters, List<String> valuesListNumbers) {
        boolean isRunning = true;
        // Scanner scanner = new Scanner(System.in);
        Coordinates square = new Coordinates(0, 0);

        while (isRunning == true) {
            String playerInput = scanner.nextLine().toUpperCase();

            char letterCoordinateChar = playerInput.charAt(0);
            String letterCoordinate = String.valueOf(letterCoordinateChar);

            char numCoordinateChar = playerInput.charAt(1);
            String numCoordinate = String.valueOf(numCoordinateChar);

            if (checkInputLength(playerInput) == true &&
                valuesListLetters.contains(letterCoordinate) && valuesListNumbers.contains(numCoordinate)) {
                square.setX(valuesListLetters.indexOf(letterCoordinate));
                square.setY(valuesListNumbers.indexOf(numCoordinate));
                isRunning = false;
            }
        }

        // scanner  .close();
        return square;
    }

    public boolean checkInputLength(String inputString) {
        if (inputString.length() == 2) {
            return true;
        } else {
            return false;
        }
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
