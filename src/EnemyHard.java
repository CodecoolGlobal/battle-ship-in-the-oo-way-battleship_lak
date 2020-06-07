import java.util.Random;

public class EnemyHard extends EnemyMedium {
    
    public EnemyHard(Ocean ocean, int enemyId) {
        super(ocean, enemyId);
    
    }

    @Override
    public void enemyTurn(Ocean ocean, String difficulty) {  
        boolean checkOneMore = true;

        while (checkOneMore) {
            if (!controller.getFindShip()) {
                chosenSqureCoordinates = getRandomCoordinatesHard(ocean);

                int coordinateX = chosenSqureCoordinates.getX();
                int coordinateY = chosenSqureCoordinates.getY();

                if (ocean.getSquares().get(coordinateY).get(coordinateX).getIsShip())
                    controller.setFindShipTrue();   
                    controller.setX(chosenSqureCoordinates.getX());
                    controller.setY(chosenSqureCoordinates.getY());
            }
            else 
                chosenSqureCoordinates = huntOnShip(ocean);
            
            if (!ocean.getSquares().get(chosenSqureCoordinates.getY()).get(chosenSqureCoordinates.getX()).getIsHit())
                checkOneMore = false;
            else
                checkOneMore = true;
        }
        markChosenSquare(chosenSqureCoordinates, ocean);
    }

    public Coordinates getRandomCoordinatesHard(Ocean ocean) {
        Random rn = new Random();
        boolean isRunning = true;
        int rowIndex = 0;
        int tileIndex = 0;

    
        while(isRunning == true) {
            int X = rn.nextInt(ocean.getSquares().get(0).size() / 2);
            int Y = rn.nextInt(ocean.getSquares().size());

            if (Y % 2 == 0) 
                rowIndex = X * 2 - 1;
            else
                rowIndex = X * 2;
            tileIndex = Y;

            if (!ocean.getSquares().get(tileIndex).get(rowIndex).getIsHit())
                isRunning = false;

        }
        Coordinates squareCoordinates = new Coordinates(rowIndex, tileIndex);
            return squareCoordinates;
    }
}