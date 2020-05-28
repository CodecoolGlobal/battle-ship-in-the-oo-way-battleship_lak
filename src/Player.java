import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {  
    private Ocean playerOcean;
    private int playerId;


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


    public void playerTurn() {
        printMessage();
        // get player choice 
        // check chosen tile for ship 
        // mark tile


    }


    public void printMessage () {
        System.out.println("It is now Player " + playerId + " turn");
    }


    // REFACTOR HERE, Create field in ocean object in which stores array of coordinates,
    // import it here
    public Coordinates getChoice (int coordinate) {
        List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        List<String> strNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        System.out.println("Choose letter of field, which you would like to strike.");
        int xCoordinate = getCoordinateFromPlayer(letters);
        Coordinates.

        System.out.println("Choose letter of field, which you would like to strike.");
        int yCoordinate = getCoordinateFromPlayer(strNumbers);

        return (xCoordinate, yCoordinate);
    }





    public int getCoordinateFromPlayer (List<String> valuesList) {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        int coordinate;

        while (isRunning == true) {
            String playerInput = scanner.nextLine().toUpperCase();
            if (valuesList.contains(playerInput)) {
                coordinate = valuesList.indexOf(playerInput);
                isRunning = false;
        }

        scanner.close();
        return coordinate;
}