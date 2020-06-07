public class EnemyController {
    protected boolean findShip;
    protected String strControl;
    protected int X, Y;

    public EnemyController() {
        this.findShip = false;
        this.strControl = "Search V/H";
        this.X = 0;
        this.Y = 0;
    }


    public void setStrControler(String string) {
        this.strControl = string;
    }


    public String getStrControler() {
        return strControl;
    }


    public void setFindShipTrue() {
        this.findShip = true;
    }


    public void setFindShipFalse() {
        this.findShip = false;
    }


    public boolean getFindShip() {
        return findShip;
    }


    public void setX(int X) {
        this.X = X;
    }


    public int getX() {
        return X;
    }


    public void setY(int Y) {
        this.Y = Y;
    }


    public int getY() {
        return Y;
    }
}