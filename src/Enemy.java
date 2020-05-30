import java.util.List;
import java.util.Random;

public class Enemy extends Player {
    private Random randomGenerator;

    public Enemy(Ocean enemyOcean, int enemyId) {
        super(enemyOcean, enemyId);
    }

    public void enemyTurn(Ocean playerOcean) {
        printMessage();
        Coordinates chosenSqureCoordinates = getRandomCoordinates();
        markChosenSquare(chosenSqureCoordinates, playerOcean);
    }


    public Coordinates getRandomCoordinates() {
        boolean isRunning = true;
        int rowIndex = 0;
        int tileIndex = 0;

        while(isRunning == true) {
            rowIndex = randomGenerator.nextInt(getPlayerOcean().getSquares().size());
            List<Square> randomRow = getPlayerOcean().getSquares().get(rowIndex);
    
            tileIndex = randomGenerator.nextInt(randomRow.size());
            Square randomSquare = randomRow.get(tileIndex);

            if(randomSquare.getIsHit() == false) {
                isRunning = false;
            }
        }
        
        Coordinates squareCoordinates = new Coordinates(rowIndex, tileIndex);
        return squareCoordinates;
    }

}