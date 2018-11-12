public abstract class Polygon extends Shape2D{
    private int sides;

    public abstract double perimeter();

    public int getSides(){
        return sides;
    }

    public void setSides(int sides){
        this.sides=sides;
    }
}