import java.lang.Math;


public class Sunk {
    
    public void checkIfSunk(Ocean ocean) {    
        for (Ship ship : ocean.getShips()) {
            int pruductSquares = 1;

            if (!ship.getIsSunk()) {
                for (int index = 0; index < ship.getShipLength(); index++) {
                    if (ship.getSquaresOfShip().get(index).getIsHit())
                        pruductSquares = pruductSquares * 1;
                    else
                        pruductSquares = pruductSquares * 0;
                }
                if (pruductSquares == 1) {
                    markSquaresAroundSunkenShip(ocean, ship);
                    ship.setIsSunk();
                }
            }
        }
    }


    private static void markSquaresAroundSunkenShip(Ocean ocean, Ship ship) {
        int cordinateX;
        int cordinateY;
        
        for (int index = 0; index < ship.getShipLength(); index++) {
            if (ship.getIsVertical()) {
                cordinateX = ship.getCoordinateX();
                cordinateY = ship.getCoordinateY() + index;
            }
            else {
                cordinateX = ship.getCoordinateX() + index;
                cordinateY = ship.getCoordinateY();
            }
            markSquares(ocean, cordinateX, cordinateY);
        }
    }


    private static void markSquares(Ocean ocean, int cordinateX, int cordinateY) {
        double radious = 1.5;
        
        for (int y = 0; y < ocean.getSquares().size(); y++) {
            for (int x = 0; x < ocean.getSquares().get(y).size(); x++) {
                if (Math.pow(radious, 2) > Math.pow(cordinateX - x, 2) + Math.pow(cordinateY - y, 2)) {
                    ocean.getSquares().get(y).get(x).hit();
                }
            }
        }
    }
}