import java.util.List;
import java.util.ArrayList;

public class Ship {

    private List<Square> squares;
    private boolean isVertical;
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

    }

    public String getNameOfShip() {
        return nameOfShip;
    }

    public boolean getIsVertical() {
        return isVertical;
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

    public Square getSqareByIndex(int index){
        return squares.get(index);
    }

    public List<Square> getSquaresOfShip() {
        return squares;
    }

}