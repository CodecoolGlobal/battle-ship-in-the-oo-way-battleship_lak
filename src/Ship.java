import java.util.List;

public class Ship {

    private List<Square> squares;
    private boolean isVertical;
    private int coordinateX;
    private int coordinateY;
    private int shipLength;

    
    public Ship(int shipLength, boolean isVertical, int coordinateX, int coordinateY) {
        // List<Square> squares;
        for (int i = 0; i < shipLength; i++) {
            Square localSquare = new Square(); 
            this.squares.add(localSquare);
        }

        // this.squares = squares;
        this.isVertical = isVertical;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY; 
        this.shipLength = shipLength;

    }

    public boolean getIsVertical(){
        return isVertical;
    }

    public int getCoordinateX(){
        return coordinateX;
    }   

    public int getCoordinateY(){
        return coordinateY;
    }

    public int getShipLength(){
        return shipLength;
    }

    public Square getSqareByIndex(int index){
        return squares.get(index);
    }

}