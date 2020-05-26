public class Square {
    private final static String SYMBOL = "X";
    private final static String SHIP = "S";
    private boolean isHit, isShip;
    
    
    public Square() {
        this.isHit = false;
        this.isShip = false;
    }


    public void hit() {
        isHit = true;
    }


    public void changeToAShip() {
        isShip = true;
    }


    public boolean getIsHit(){
        return isHit;
    }


    public boolean getIsShip() {
        return isShip;
    }


    @Override
    public String toString() {
        if (isHit)
            return SYMBOL;
        else if (isShip)
            return SHIP;
        else
            return " ";
        //return isHit ? SYMBOL : " ";
    }
}