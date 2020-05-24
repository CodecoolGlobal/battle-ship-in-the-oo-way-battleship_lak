public class Square {
    private final static String SYMBOL = "X";

    private boolean isHit;
    
    /*
    public Square() {
        this.isHit = isHit;i
    }*/


    public void hit() {
        isHit = true;
    }

    public boolean getIsHit(){
        return isHit;
    }


    @Override
    public String toString() {
        return isHit ? SYMBOL : " ";
    }
}