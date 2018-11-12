public class Triangle extends Polygon{
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.x3=x3;
        this.y3=y3;
    }

    public double area(double x1, double y1, double x2, double y2, double x3, double y3){
        double lace1 = (x1*y2)+(x2*y3)+(x3*y1);
        double lace2 = (y1*x2)+(y2*x3)+(y3*x1);

        double diff = Math.abs(lace1-lace2);

        return diff/2;
    }

    double x1, y1, x2, y2, x3, y3;
}