public abstract class Shape2D extends Shape{
    public abstract double area();

    public double distanceFormula(double x1, double x2, double y1, double y2){
        double leg1 = (x1-x2)*(x1-x2);
        double leg2 = (y1-y2)*(y1-y2);

        return Math.sqrt(leg1+leg2);
    }
}