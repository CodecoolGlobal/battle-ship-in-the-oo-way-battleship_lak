public class Square {
    private final static String SYMBOL = "X";
    private final static String SHIP = "$";
    private boolean isHit, isShip, isHidden;
    
    
    public Square() {
        this.isHit = false;
        this.isShip = false;
        this.isHidden = false;  // change on true for all squares of ships when you want print board enemy or other player
    }


    public void hit() {
        this.isHit = true;
    }


    public void changeToAShip() {
        this.isShip = true;
    }


    public boolean getIsHit() {
        return isHit;
    }


    public boolean getIsShip() {
        return isShip;
    }


    public void setHidden() {
        this.isHidden = true;
    }


    @Override
    public String toString() {
        if (isHit && isShip)
            return SYMBOL;
        else if (isShip && !isHidden)
            return SHIP;
        else if (isHit)
            return "&";
        else
            return " ";
    }
}