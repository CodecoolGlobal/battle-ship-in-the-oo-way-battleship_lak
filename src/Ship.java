import java.util.List;

public class Ship {

    private List<Square> squares;
    
    public Ship(int shipLenght) {
        for (int i = 0; i < shipLenght; i++) {
            Square localSquare = new Square(); 
            this.squares.add(localSquare);
        }
        //this.squares = squares;
    }

}