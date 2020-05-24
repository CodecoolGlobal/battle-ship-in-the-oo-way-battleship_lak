import java.util.List;

public class Ship {

    private List<Square> squares;
    private boolean isVertical;
    private int coordinateX;
    private int coordinateY;
    
    public Ship(int shipLenght, boolean isVertical, int coordinateX, int coordinateY) {
        for (int i = 0; i < shipLenght; i++) {
            Square localSquare = new Square(); 
            this.squares.add(localSquare);
        }
        this.isVertical = isVertical;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY; 
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

}