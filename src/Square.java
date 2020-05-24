public class Square {
    private final static String SYMBOL = "X";
    private boolean isHit;
    
    /*
    public Square() {
        this.isHit = isHit;
    }*/


    public void hit() {
        isHit = true;
    }


    @Override
    public String toString() {
        return isHit ? SYMBOL : " ";
    }
}