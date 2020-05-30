import java.util.List;
import java.util.ArrayList;

public class Ship {

    private List<Square> squares;
    private boolean isVertical, isSunk;
    private int coordinateX, coordinateY, shipLength;
    private String nameOfShip;

    
    public Ship(String nameOfShip, int shipLength, boolean isVertical, int coordinateX, int coordinateY) {
        
        //to private method ---------------------------------
        List<Square> squares = new ArrayList<Square>();
        for (int i = 0; i < shipLength; i++) {
            Square localSquare = new Square();
            localSquare.changeToAShip();
            squares.add(localSquare);
        }
        //-----------------------------------------------------
        this.squares = squares;
        this.nameOfShip = nameOfShip;
        this.isVertical = isVertical;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY; 
        this.shipLength = shipLength;
        this.isSunk = false; // change on true when all squares of ship will be hit
    }


    public String getNameOfShip() {
        return nameOfShip;
    }


    public boolean getIsVertical() {
        return isVertical;
    }


    public void setVertical() {
        this.isVertical = true;
    }


    public void setHorizontal() {
        this.isVertical = false;
    }


    public int getCoordinateX() {
        return coordinateX;
    }   


    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }


    public int getCoordinateY() {
        return coordinateY;
    }


    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }


    public int getShipLength() {
        return shipLength;
    }


    public boolean getIsSunk() {
        return isSunk;
    }


    public void setIsSunk() {
        this.isSunk = true;
    }


    public Square getSqareByIndex(int index){
        return squares.get(index);
    }


    public List<Square> getSquaresOfShip() {
        return squares;
    }


    public void updateIsSunk () {
        boolean shouldBeSunk = true;
        for (int index = 0; index < squares.size(); index++) {
            Square nextSquare = squares.get(index);
            if (nextSquare.getIsHit() == false ) {
                shouldBeSunk = false;
            }
        }
        if (shouldBeSunk == true) {
            isSunk = true;
        }
    }
}