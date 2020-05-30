import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
            List<List<Square>> targetMatrix = new ArrayList<List<Square>>();
            targetMatrix = getPlayerOcean().getSquares();
            rowIndex = ThreadLocalRandom.current().nextInt(0, targetMatrix.size());
            // rowIndex = randomGenerator.nextInt(targetMatrix.size());
            List<Square> randomRow = targetMatrix.get(rowIndex);
    
            tileIndex = ThreadLocalRandom.current().nextInt(0, randomRow.size());
            Square randomSquare = randomRow.get(tileIndex);

            if(randomSquare.getIsHit() == false) {
                isRunning = false;
            }
        }
        
        Coordinates squareCoordinates = new Coordinates(rowIndex, tileIndex);
        return squareCoordinates;
    }

}