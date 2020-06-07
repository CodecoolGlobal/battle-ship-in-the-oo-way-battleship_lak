import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EnemyMedium extends Enemy {
    protected Coordinates chosenSqureCoordinates = new Coordinates(0, 0);
    protected EnemyController controller = new EnemyController();
    protected Random rn = new Random();
    //protected int X, Y;

    public EnemyMedium(Ocean ocean, int enemyId) {
        super(ocean, enemyId);
    }


    @Override
    public void enemyTurn(Ocean ocean) {  
        boolean checkOneMore = true;

        while (checkOneMore) {
            if (!controller.getFindShip()) {
                chosenSqureCoordinates = getRandomCoordinates_easy();

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


    protected Coordinates huntOnShip(Ocean ocean) {
        //int coordinateX = chosenSqureCoordinates.getX();
        //int coordinateY = chosenSqureCoordinates.getY();

        if (controller.getStrControler().equals("Search V/H")) {
            chosenSqureCoordinates = getRandomCoordinatesByVerticalAndHorizontal(ocean);
            if (ocean.getSquares().get(chosenSqureCoordinates.getY()).get(chosenSqureCoordinates.getX()).getIsShip()) {
                checkIfVerticalOrHorizontal(chosenSqureCoordinates);
            }
        }
        else if (controller.getStrControler().equals("Vertical")) {
            chosenSqureCoordinates = huntOnShipByVertical(ocean, chosenSqureCoordinates);
        }
        else if (controller.getStrControler().equals("Horizontal")) {
            chosenSqureCoordinates = huntOnShipByHorizontal(ocean, chosenSqureCoordinates);
        }

        return chosenSqureCoordinates;
    }


    protected Coordinates getRandomCoordinatesByVerticalAndHorizontal(Ocean ocean) {
        List<Coordinates> squares = new ArrayList<Coordinates>();
        int X = controller.getX();
        int Y = controller.getY();


        if (X - 1 >= 0) {
            if (!ocean.getSquares().get(Y).get(X - 1).getIsHit()) {
                Coordinates coordinates = new Coordinates(X - 1, Y);
                squares.add(coordinates);
                }
            }
        if (X + 1 < ocean.getSquares().get(Y).size()) {
            if (!ocean.getSquares().get(Y).get(X + 1).getIsHit())  {
                Coordinates coordinates = new Coordinates(X + 1, Y);
                squares.add(coordinates);
                }
            }
        if (Y - 1 >= 0) {
            if (!ocean.getSquares().get(Y - 1).get(X).getIsHit()) {
                Coordinates coordinates = new Coordinates(X, Y - 1);
                squares.add(coordinates);
                }
            }
        if (Y + 1 < ocean.getSquares().size()) {
            if (!ocean.getSquares().get(Y + 1).get(X).getIsHit()) {
                Coordinates coordinates = new Coordinates(X, Y + 1);
                squares.add(coordinates);
                }
        }

        if (squares.size() > 0) {
            int index = rn.nextInt(squares.size());
            chosenSqureCoordinates.setX(squares.get(index).getX());
            chosenSqureCoordinates.setY(squares.get(index).getY());
        }
        else
            controller.setFindShipFalse();

        return chosenSqureCoordinates;
    }


    protected void checkIfVerticalOrHorizontal(Coordinates chosenSqureCoordinates) {
        System.out.println(chosenSqureCoordinates.getX());
        System.out.println(controller.getX());
        System.out.println(chosenSqureCoordinates.getY());
        System.out.println(controller.getY());
        
        if (chosenSqureCoordinates.getX() == controller.getX())
            controller.setStrControler("Vertical");   
        else if (chosenSqureCoordinates.getY() == controller.getY())
            controller.setStrControler("Horizontal");
    }


    protected Coordinates huntOnShipByVertical(Ocean ocean, Coordinates chosenSqureCoordinates) {
        boolean inUp = true;
        boolean inDown = true;
        int nextY = 1;

        while (inUp) {
            if (chosenSqureCoordinates.getY() - nextY >= 0) {
                int coordinateX = chosenSqureCoordinates.getX();
                int coordinateY = chosenSqureCoordinates.getY();
                boolean isShip = ocean.getSquares().get(coordinateY - nextY).get(coordinateX).getIsShip();
                boolean isHit = ocean.getSquares().get(coordinateY - nextY).get(coordinateX).getIsHit();

                if (isShip && isHit) 
                    nextY++;
                else if (isShip && !isHit) {
                    chosenSqureCoordinates.setY(coordinateY - nextY);
                    return chosenSqureCoordinates;
                }
                else
                    inUp = false;
            }
            else
                inUp = false;
        }
        nextY = 1;

        while (inDown) {
            if (chosenSqureCoordinates.getY() + nextY < ocean.getSquares().size()) {
                int coordinateX = chosenSqureCoordinates.getX();
                int coordinateY = chosenSqureCoordinates.getY();
                boolean isShip = ocean.getSquares().get(coordinateY + nextY).get(coordinateX).getIsShip();
                boolean isHit = ocean.getSquares().get(coordinateY + nextY).get(coordinateX).getIsHit();

                if (isShip && isHit) 
                    nextY++;
                else if (isShip && !isHit) {
                    chosenSqureCoordinates.setY(coordinateY + nextY);
                    return chosenSqureCoordinates;
                }
                else
                    inDown = false;
            }
            else
                inDown = false;
        }
        controller.setFindShipFalse();
        controller.setStrControler("Search V/H");

        return chosenSqureCoordinates;
    }


    protected Coordinates huntOnShipByHorizontal(Ocean ocean, Coordinates chosenSqureCoordinates) {
        boolean inLeft = true;
        boolean inRight= true;
        int nextX = 1;

        while (inLeft) {
            if (chosenSqureCoordinates.getX() - nextX >= 0) {
                int coordinateX = chosenSqureCoordinates.getX();
                int coordinateY = chosenSqureCoordinates.getY();
                boolean isShip = ocean.getSquares().get(coordinateY).get(coordinateX - nextX).getIsShip();
                boolean isHit = ocean.getSquares().get(coordinateY).get(coordinateX - nextX).getIsHit();

                if (isShip && isHit) 
                    nextX++;
                else if (isShip && !isHit) {
                    chosenSqureCoordinates.setX(coordinateX - nextX);
                    return chosenSqureCoordinates;
                }
                else
                    inLeft = false;
            }
            else
                inLeft = false;
        }
        nextX = 1;

        while (inRight) {
            if (chosenSqureCoordinates.getX() + nextX < ocean.getSquares().get(chosenSqureCoordinates.getY()).size()) {
                int coordinateX = chosenSqureCoordinates.getX();
                int coordinateY = chosenSqureCoordinates.getY();
                boolean isShip = ocean.getSquares().get(coordinateY).get(coordinateX + nextX).getIsShip();
                boolean isHit = ocean.getSquares().get(coordinateY).get(coordinateX + nextX).getIsHit();

                if (isShip && isHit) 
                    nextX++;
                else if (isShip && !isHit) {
                    chosenSqureCoordinates.setX(coordinateX + nextX);
                    return chosenSqureCoordinates;
                }
                else
                    inRight = false;
            }
            else
                inRight = false;
        }
        controller.setFindShipFalse();
        controller.setStrControler("Search V/H");

        return chosenSqureCoordinates;
    }
}