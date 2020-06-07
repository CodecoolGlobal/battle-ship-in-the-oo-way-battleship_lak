import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Player {

    public Enemy(Ocean enemyOcean, int enemyId) {
        super(enemyOcean, enemyId);
    }


    public void enemyTurn(Ocean playerOcean, String difficulty) {
        // printMessage();
        if (difficulty == "easy") {
            Coordinates chosenSqureCoordinates = getRandomCoordinates_easy();
            markChosenSquare(chosenSqureCoordinates, playerOcean);
        } else if (difficulty == "hard") {
            Coordinates chosenSqureCoordinates = getCoordinates_hard_LL(playerOcean);
            markChosenSquare(chosenSqureCoordinates, playerOcean);
        }
    }


    public Coordinates getRandomCoordinates_easy() {
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


    public Coordinates getCoordinates_hard_LL(Ocean playerOcean) {
        
        Coordinates coordinatesCandidate = new Coordinates(0, 0);
        boolean candidateCorrect = false;
        
        while (candidateCorrect == false) {
            coordinatesCandidate = getRandomCoordinates_easy();
            int candidateX = coordinatesCandidate.getX();
            int candidateY = coordinatesCandidate.getY();
    
            //return non-sink ship
            int minShipLength = 3;
    
            List<Square> verticalRow = generateVerticalList(candidateX, playerOcean);
            List<Square> horizontalRow = generateHorizontalList(candidateY, playerOcean);
    
            int freeSpaceVertical = getFreeTilesQty(verticalRow, candidateY);
            int freeSpaceHorizontal = getFreeTilesQty(horizontalRow, candidateX);
            
            if (freeSpaceHorizontal >= minShipLength || freeSpaceVertical >= minShipLength ) {
                candidateCorrect = true;
            }
        }
        return coordinatesCandidate;
    }


    private int getFreeTilesQty(List<Square> row, int refElementIndex) {
        int freeLengthCombined = getFreeTilesOneSide(row, refElementIndex, true)
         + getFreeTilesOneSide(row, refElementIndex, false) + 1;

        return freeLengthCombined;
    }


    private int getFreeTilesOneSide(List<Square> row, int refElementIndex, boolean goRigth) {
        int iterator = 0;
        if (goRigth == true) {
            iterator = 1;
        } else {
            iterator = -1;
        }

        int freeLength = 0;
        int currentTileIndicator = refElementIndex;
        Square currentSquare = row.get(currentTileIndicator);
        boolean shouldRun = true;

        while(shouldRun == true) {
            try {
                currentTileIndicator = currentTileIndicator + iterator;
                currentSquare = row.get(currentTileIndicator);
                if (currentSquare.getIsHit() == false) {
                    freeLength += 1;
                } else {
                    shouldRun = false;
                }
            } catch (Exception ArrayIndexOutOfBoundsException) {
                shouldRun = false;
            }
        }
        return freeLength;
    }


    private List<Square> generateHorizontalList (int indexY, Ocean playerOcean) {
        
        List<List<Square>> oceanTiles = playerOcean.getSquares();
        List<Square> horizontalList = oceanTiles.get(indexY);

        return horizontalList;
    }


    private List<Square> generateVerticalList (int indexX, Ocean playerOcean) {
        List<Square> verticalList = new ArrayList<Square>();
        List<List<Square>> oceanTiles = playerOcean.getSquares();
        for (int indexY = 0; indexY < oceanTiles.size(); indexY++) {
            Coordinates squareCoordinates = new Coordinates(indexX, indexY);
            verticalList.add(playerOcean.getSqare(squareCoordinates));
        }
        return verticalList;
    }
}